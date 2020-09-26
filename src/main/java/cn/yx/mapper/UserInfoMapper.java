package cn.yx.mapper;

import cn.yx.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 个人信息持久化对象
 * @author liyixuan
 */
public interface UserInfoMapper {
    /**
     * 查询用户信息
     * @param username 用户名
     * @return
     */
    User findUser(String username);

    /**
     * 修改用户信息
     * @param username1
     * @param phone
     * @param portrait
     */
    void UserReset(@Param("username1") String username1,@Param("phone") Integer phone,@Param("portrait") String portrait,@Param("username") String username);


}
