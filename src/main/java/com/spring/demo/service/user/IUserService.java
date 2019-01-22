package com.spring.demo.service.user;

import com.spring.demo.model.user.User;

/**
 * 用户接口
 */
public interface IUserService {

    /**
     * 根据ID查询用户
     * @param id 用户ID
     * @return
     * @throws Exception
     */
    public User getUserById(String id) throws Exception;

    /**
     * 根据userNo查询用户
     * @param userNo 用户编码
     * @return
     * @throws Exception
     */
    public User getUserByUserNo(String userNo) throws Exception;

    /**
     * 用户注册
     * @param user 用户
     * @throws Exception
     */
    public int setUser(User user) throws Exception;
}
