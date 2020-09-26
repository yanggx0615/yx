package cn.yx.controller;

import cn.yx.bean.User;
import cn.yx.service.UserInfoService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 个人信息Controller
 * @author liyixuan
 */

@RestController
@RequestMapping("userInfo")
//@SessionAttributes("userSet")
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private ServletContext servletContext;

    /**
     * 查看个人信息
     * @param request
     * @return
     */
    @GetMapping("/find")
    public ModelAndView findUser(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("userInfo/userMessage");
        request.getSession().setAttribute("user",userInfoService.findUser("123"));
        User user1 = (User) request.getSession().getAttribute("user");
        User user = userInfoService.findUser(user1.getUsername());
        modelAndView.addObject("user",user);
        //request.getSession().setAttribute("user",user);
        return modelAndView;
    }

    /**
     * 跳转到修改用户详情页面
     * @param request
     * @return
     */
    @GetMapping("/sets")
    public ModelAndView UserSet1(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
//        System.out.println(user.getUsername());
        ModelAndView modelAndView = new ModelAndView("userInfo/userReset");
        return modelAndView;
    }

    /**
     * 修改用户信息
     * @param request
     * @return
     */
    @PostMapping("/set")
    @ResponseBody
    public ModelAndView UserSet(@RequestParam("file")MultipartFile file, HttpServletRequest request, RedirectAttributes redirectAttributes){
        //获取user和他的username
        User user = (User) request.getSession().getAttribute("user");
        String username = user.getUsername();
        String portrait = null;
        //文件上传
        String path = servletContext.getRealPath("head");
        File head = new File(path);
        if(!head.exists()){
            head.mkdirs();
        }
        try {
            File file1 = new File(head, file.getOriginalFilename());
            portrait = file1.getAbsolutePath();
            System.out.println(portrait);
            file.transferTo(Paths.get(file1.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error","文件上传出错");
        }
        //获取form中的信息
        String username1 = request.getParameter("username1");
        Integer phone = Integer.valueOf(request.getParameter("phone"));
//        if(username1==null){
//            //redirectAttributes.addFlashAttribute("error","输入不能为空");
//            username1=user.getUsername();
//        }else if (phone==null){
//            phone=user.getPhone();
//        }else if(portrait==null){
//            portrait=user.getPortrait();
//        }
        if (portrait==null){
            portrait=user.getPortrait();
        }
        User user1 = userInfoService.findUser(username1);
        if ((!Objects.equals(username1, username)) &&user1 != null){
            redirectAttributes.addFlashAttribute("error","用户名已被使用");
            ModelAndView modelAndView = new ModelAndView("redirect:/userInfo/sets");
            return modelAndView;
        }
        userInfoService.UserReset(username1,phone,portrait,username);
        user.setPhone(phone);
        user.setUsername(username1);
        user.setPortrait(portrait);
        request.getSession().setAttribute("user",user);
        ModelAndView modelAndView = new ModelAndView("userInfo/userMessage");
        return modelAndView;
    }

//    @GetMapping("/userInfo")
//    public ModelAndView home(){
//        System.out.println("1");
//        return new ModelAndView("userInfo/UserInfo");
//    }
}
