package com.spring.demo.service.user.impl;

import com.spring.demo.dao.user.IUserDao;
import com.spring.demo.model.user.User;
import com.spring.demo.service.user.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 用户接口实现类
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    /**
     * 根据ID查询用户
     * @param id 用户ID
     * @return
     * @throws Exception
     */
    @Override
    public User getUserById(String id) throws Exception {
        return userDao.getUserById(id);
    }


    /**
     * 根据userNo查询用户
     * @param userNo 用户编码
     * @return
     * @throws Exception
     */
    @Override
    public User getUserByUserNo(String userNo) throws Exception {
        return StringUtils.isBlank(userNo) ? null : userDao.getUserByUserNo(userNo);
    }

    /**
     * 添加用户
     * @param user 用户
     * @throws Exception
     */
    @Override
    public int setUser(User user) throws Exception {
        Date today = new Date();
        user.setCreateTime(today);
        user.setUpdateTime(today);
       return null == user ? 0 : userDao.insert(user);
    }

    /**
     * 按条件筛选出用户列表
     * @param user 用户
     * @return
     * @throws Exception
     */
    @Override
    public List<User> getAllByUser(User user) throws Exception {
        return null == user ? null : userDao.getAllByUser(user);
    }
}
