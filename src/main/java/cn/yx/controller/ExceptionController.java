package cn.yx.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 杨国祥
 * 全局异常处理
 */
@ControllerAdvice
public class ExceptionController {
    /**
     * 访问找不到时
     * @param e 未找到处理异常
     * @param response 响应对象
     * @return 返回JSON或者返回视图
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public Object noHandlerFoundException(NoHandlerFoundException e, HttpServletResponse response){
        String accept = response.getHeader("accept");
        if(accept.contains(MediaType.APPLICATION_JSON_VALUE)){
            Map<String,Object> map = new HashMap<>();
            map.put("url",e.getRequestURL());
            map.put("method",e.getHttpMethod());
            return new ResponseEntity(map, HttpStatus.NOT_FOUND);
        }else{
            ModelAndView modelAndView =new ModelAndView("forward:/error/404",HttpStatus.NOT_FOUND);
            modelAndView.addObject("url",e.getRequestURL());
            modelAndView.addObject("method",e.getHttpMethod());
            return modelAndView;

        }
    }



}
