package cn.yx.service.impl;

import cn.yx.bean.Data;
import cn.yx.bean.User;
import cn.yx.mapper.DataMapper;
import cn.yx.service.DateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class DateServiceImpl implements DateService {
    @Resource
    private DataMapper dataMapper;
    @Override
    public String add(Data data) {
        if(dataMapper.add(data)>0){
            return "添加成功";
        }
        return "添加失败";
    }

    @Override
    public List<Data> sortordByDate(String type, User user, String status) {
        return dataMapper.sortordByDate(type,user,status);
    }

    @Override
    public List<Data> sortordByHits(String type, User user, String status) {
        return dataMapper.sortordByHits(type,user,status);
    }

    @Override
    public List<Data> sortordByCollection(String type, User user, String status) {
        return dataMapper.sortordByCollection(type,user,status);
    }

    @Override
    public String addHits(String dataId) {
        if(dataMapper.addHits(dataId)>0){
            return "点赞成功";
        }
        return "点赞失败";
    }

    @Override
    public String addCollection(String dataId) {
        if(dataMapper.addCollection(dataId)>0){
            return "收藏成功";
        }
        return "收藏失败";
    }

    @Override
    public String updateStatus(String status, String dataId) {
        if(dataMapper.updateStatus(status,dataId)>0){
            return "修改成功";
        }
        return "修改失败";
    }
}
