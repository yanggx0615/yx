package cn.yx.controller;

import cn.yx.annotation.NoLogin;
import cn.yx.bean.Data;
import cn.yx.bean.User;
import cn.yx.service.DateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class VideoController {
    @Resource
    private ServletContext servletContext;
    @Resource
    private DateService dateService;

    @NoLogin
    @GetMapping("/main")
    public String home(){
        return "/main";
    }

    /**
     * 访问主页面
     * @param request
     * @param response
     * @return
     */
    @NoLogin
    @RequestMapping("/main")
    public ModelAndView main(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView("main");
        User user = (User) request.getSession().getAttribute("user");
        String pageNum = request.getParameter("pageNum");
        if(pageNum == null){
            pageNum = "1";
        }
        String type = request.getParameter("type");
        PageHelper.startPage(new Integer(pageNum),5);
        List<Data> dataList = dateService.sortordByDate(type, user, "审核通过");
        PageInfo<Data> pageInfo = new PageInfo<>(dataList);
        System.out.println(pageInfo);
        modelAndView.addObject("pageInfo",pageInfo);
        return modelAndView;
    }


    /**
     * 上传视频平返回结果
     * @param request 请求
     * @param file 文件
     * @param name 文件名
     * @return 执行结果
     */
    @ResponseBody
    @RequestMapping("/uploadvideo")
    public String uploading(HttpServletRequest request, @RequestParam("file") MultipartFile file, @RequestParam("name") String name){
        String realPath = servletContext.getRealPath("/upload/void");
        File uploadDir = new File(realPath);
        User user = (User) request.getSession().getAttribute("user");
        if(!uploadDir.exists()){
            uploadDir.mkdirs();
        }
        try {
            String dataId = UUID.randomUUID().toString().replace("-", "");
            file.transferTo(new File(uploadDir,dataId+".mp4"));
            Data data =new Data();
            data.setAuthor(user.getUsername()).setDataId(dataId).setName(name).setDataDate(new Date());
            data.setStatus("未审核").setHits(0).setCollection(0).setType("搞笑视频");
            return dateService.add(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "添加失败";
    }
}
