package com.spring.demo.service.authority;

import com.spring.demo.model.authority.Menu;
import com.spring.demo.model.user.User;

import java.util.List;

/**
 * 菜单接口
 */
public interface IMenuService {

    /**
     * 根据用户来查询菜单
     * @return
     */
    List<Menu> getAllByUser(User user) throws Exception;

    /**
     * 查询菜单
     * @return
     * @throws Exception
     */
    List<Menu> getAll() throws Exception;
}
