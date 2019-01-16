package com.spring.demo.service.user.impl;

import com.spring.demo.dao.user.IUserDao;
import com.spring.demo.model.user.User;
import com.spring.demo.service.user.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public User getUser() throws Exception {
        return userDao.getUserById("1");
    }

    @Override
    public User getUserByUserNo(String userNo) throws Exception {
        return StringUtils.isBlank(userNo) ? null : userDao.getUserByUserNo(userNo);
    }

    @Override
    public int setUser(User user) throws Exception {
        Date today = new Date();
        user.setCreateTime(today);
        user.setUpdateTime(today);
       return null == user ? 0 : userDao.insert(user);
    }
}
