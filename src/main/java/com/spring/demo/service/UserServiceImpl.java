package com.spring.demo.service;

import com.spring.demo.dao.UserMapper;
import com.spring.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser() throws Exception {
        return userMapper.selectByPrimaryKey("1");
    }
}
