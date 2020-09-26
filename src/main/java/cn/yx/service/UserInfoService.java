package cn.yx.service;

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
     * @return
     */
    User findUser(String username);

    /**
     * 修改用户信息
     * @param username
     * @param phone
     * @param portrait
     */
    void UserReset(String username1,Integer phone,String portrait,String username);
}
