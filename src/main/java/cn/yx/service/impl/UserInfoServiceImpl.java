package cn.yx.service.impl;

import cn.yx.bean.Collect;
import cn.yx.bean.User;
import cn.yx.mapper.UserInfoMapper;
import cn.yx.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liyixuan
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoMapper userInfoMapper;
    /**
     * 查询用户信息
     * @param username 用户名
     * @return
     */
    public User findUser(String username) {
        return userInfoMapper.findUser(username);
    }

    /**
     * 修改用户信息
     * @param username
     * @param phone
     * @param portrait
     */
    public void UserReset(String username1,Integer phone,String portrait,String username){
        userInfoMapper.UserReset(username1,phone,portrait,username);
    }

    /**
     * 查询我的收藏
     * @param username 用户名
     * @return
     */
    @Override
    public List<Collect> findMyCollect(String username) {
        return userInfoMapper.findMyCollect(username);
    }
}
