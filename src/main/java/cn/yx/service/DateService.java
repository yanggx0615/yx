package cn.yx.service;

import cn.yx.bean.Data;
import cn.yx.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DateService {
    /**
     * 增加数据
     * @param data 数据
     * @return 受影响的行数
     */
    String add(@Param("data") Data data);

    /**
     * 如果没有用户对象，查找指定类型的数据并根据日期排序
     * 如果有，查找指定类型和用户的数据并根据日期排序
     * @param type 类别
     * @param user 用户
     * @return 查到的数据
     */
    List<Data> sortordByDate(@Param("type") String type, @Param("user") User user, @Param("status") String status);

    /**
     * 如果没有用户对象，查找指定类型的数据并根据点击量排序
     * 如果有，查找指定类型和用户的数据并根据点击量排序
     * @param type 类别
     * @param user 用户
     * @return 查到的数据
     */
    List<Data> sortordByHits(@Param("type") String type,@Param("user") User user,@Param("status") String status);

    /**
     * 如果没有用户对象，查找指定类型的数据并根据收藏量排序
     * 如果有，查找指定类型和用户的数据并根据收藏量排序
     * @param type 类别
     * @param user 用户
     * @return 查到的数据
     */
    List<Data> sortordByCollection(@Param("type") String type,@Param("user") User user,@Param("status") String status);

    /**
     * 增加点赞数据
     * @param dataId 被修改的数据Id
     * @return 执行的结果
     */
    String addHits(String dataId);

    /**
     * 增加收藏数据
     * @param dataId 被修改的数据Id
     * @return 执行的结果
     */
    String addCollection(String dataId);

    /**
     * 根据数据编号修改状态
     * @param status 状态
     * @param dataId 数据编号
     * @return 执行结果
     */
    String updateStatus(@Param("status") String status,@Param("dataId") String dataId);
}
