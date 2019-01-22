package com.spring.demo.service.authority.impl;

import com.spring.demo.dao.authority.IMenuDao;
import com.spring.demo.model.authority.Menu;
import com.spring.demo.model.user.User;
import com.spring.demo.service.authority.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单接口实现类
 */
@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private IMenuDao menuDao;


    @Override
    public List<Menu> getAllByUser(User user) throws Exception {
        return null == user ? null : menuDao.getAllByUser( user );
    }

    @Override
    public List<Menu> getAll() throws Exception {
        return menuDao.getAll(  );
    }
}
