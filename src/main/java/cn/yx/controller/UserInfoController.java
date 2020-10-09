package cn.yx.controller;

import cn.yx.bean.Collect;
import cn.yx.bean.Data;
import cn.yx.bean.User;
import cn.yx.service.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
        //测试，设一个user
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
        if (!file.isEmpty()){
            String path = servletContext.getRealPath("head");
            File head = new File(path);
            if(!head.exists()){
                head.mkdirs();
            }
            try {
                File file1 = new File(head, file.getOriginalFilename());
                portrait = file1.getName();
                file.transferTo(Paths.get(file1.getAbsolutePath()));
            } catch (IOException e) {
                e.printStackTrace();
                redirectAttributes.addFlashAttribute("error","文件上传出错");
            }
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
        if (portrait == null){
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


    /**
     * 查看我的收藏
     * @param request
     * @return
     */
    @GetMapping("/collect")
    public ModelAndView findMyCollect(HttpServletRequest request){
        //获取username
        User user = (User)request.getSession().getAttribute("user");
        String username = user.getUsername();
        //查询分页
        List<Collect> list = userInfoService.findMyCollect(username);
        ModelAndView modelAndView = new ModelAndView("userInfo/userCollect");
        modelAndView.addObject(list);
        String pageNum = request.getParameter("pageNum");
        if(pageNum == null){
            pageNum="1";
        }
        PageHelper.startPage(new Integer(pageNum),5);
        PageInfo<Collect> pageInfo = new PageInfo<>(list);
        System.out.println(pageInfo);
        request.setAttribute("pageInfo",pageInfo);
        request.setAttribute("method","findCollect");
        System.out.println("................");
        return modelAndView;
    }

    /**
     * 查看我的发布
     * @param request
     * @return
     */
    @GetMapping("/myData")
    public ModelAndView findMyData(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        String username = user.getUsername();

        List<Data> list = userInfoService.findMyData(username);
        ModelAndView modelAndView = new ModelAndView("userInfo/userData");
        modelAndView.addObject(list);
        String pageNum = request.getParameter("pageNum");
        if(pageNum == null){
            pageNum="1";
        }
        PageHelper.startPage(new Integer(pageNum),5);
        PageInfo<Collect> pageInfo = new PageInfo(list);
        System.out.println(pageInfo);
        request.setAttribute("pageInfo",pageInfo);
        request.setAttribute("method","findData");
        return modelAndView;
    }
}
