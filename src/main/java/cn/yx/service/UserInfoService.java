package cn.yx.service;

import cn.yx.bean.Collect;
import cn.yx.bean.Data;
import cn.yx.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 个人信息业务接口
 * @author liyixuan
 */
public interface UserInfoService {
    /**
     * 查询用户信息
     * @param username 用户名
     * @return 用户
     */
    User findUser(String username);

    /**
     * 修改用户信息
     * @param username1 新用户名
     * @param username 用户名
     * @param phone 电话
     * @param portrait 头像
     */
    void UserReset(String username1,Integer phone,String portrait,String username);

    /**
     * 查询我的收藏
     * @param username 用户名
     * @return
     */
    List<Collect> findMyCollect(String username);

    /**
     * 查看我的发布
     * @param username 用户名
     * @return
     */
    List<Data> findMyData(String username);
}
