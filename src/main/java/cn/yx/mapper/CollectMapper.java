package cn.yx.mapper;

import cn.yx.bean.Collect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectMapper {

    /**
     * 新增收藏数据
     * @param collect 收藏的数据
     * @return 返回受影响的行数
     */
    int add(@Param("Collect") Collect collect);

    /**
     * 删除指定编号的收藏
     * @param Collect_Id 收藏编号
     * @return 受影响行数
     */
    int drop(@Param("Collect_Id") String Collect_Id);

    /**
     * 找到指定用户名的收藏数据
     * @param username 用户名
     * @return 收藏的列表
     */
    List<Collect> findByUser(@Param("username") String username);

}
