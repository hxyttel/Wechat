package com.weixin.service.impl;

import com.weixin.bean.User;
import com.weixin.mapper.UserMapper;
import com.weixin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public int saveModel(User user) {
        return userMapper.saveModel(user);
    }

    @Override
    public int updateModel(User user) {
        return userMapper.updateModel(user);
    }

    @Override
    public int deleteModel(User user) {
        return userMapper.deleteModel(user);
    }

    @Override
    public List<User> listModel() {
        return userMapper.listModel();
    }

    @Override
    public User getModel(Integer uid) {
        return userMapper.getModel(uid);
    }


}
