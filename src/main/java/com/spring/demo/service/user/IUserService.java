package com.spring.demo.service.user;

import com.spring.demo.model.user.User;

public interface IUserService {

    public User getUser() throws Exception;

    /**
     * 根据userNo查询用户
     * @param userNo
     * @return
     * @throws Exception
     */
    public User getUserByUserNo(String userNo) throws Exception;

    /**
     * 用户注册
     * @param user
     * @throws Exception
     */
    public int setUser(User user) throws Exception;
}
