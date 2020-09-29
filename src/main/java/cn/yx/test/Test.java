package cn.yx.test;

import cn.yx.bean.Data;
import cn.yx.bean.User;
import cn.yx.service.DateService;
import cn.yx.service.impl.DateServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        DateService dateService = applicationContext.getBean(DateServiceImpl.class);
        Data data = new Data();
//        data.setCollection(10).setAuthor("张三").setDataDate(new Date()).setDataId("123456").setHits(50).setType("搞笑视频").setName("你好").setStatus("审核通过");
//        dateService.add(data);

    }

}
