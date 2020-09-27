package cn.yx.mapper;

import cn.yx.bean.Data;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DataMapper {

    //上传数据
    int add(@Param("data") Data data);

    //根据类型查找
    List<Data> findByType(String type);



}
