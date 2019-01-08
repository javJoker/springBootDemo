package com.spring.demo.service.user.impl;

import com.spring.demo.dao.user.IUserDao;
import com.spring.demo.model.user.User;
import com.spring.demo.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public User getUser() throws Exception {
        return userDao.selectByPrimaryKey("1");
    }
}
