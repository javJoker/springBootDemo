package com.spring.demo.authority;

import com.spring.demo.main.SpringBootDemoApplication;
import com.spring.demo.model.authority.Menu;
import com.spring.demo.model.user.User;
import com.spring.demo.service.authority.IMenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.spring.demo.constant.BaseConstant.NO_DEL_FLAG;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={SpringBootDemoApplication.class}) // 指定启动类
public class MenuServiceTest {

    @Autowired
    private IMenuService menuService;

    @Test
    public void testGetAll() throws Exception{
        List<Menu> menuList = menuService.getAll( null );
        System.out.println("=======================");
        menuList.forEach( menu -> {
            System.out.println( menu.toString() );
        } );
        System.out.println("=======================");
    }

    @Test
    public void testAdd() throws Exception{
        Menu menu = new Menu();
        menu.setId( UUID.randomUUID().toString().trim().replaceAll( "-", "" ));
        menu.setName( "菜单二" );
        menu.setSn( "c2" );
        menu.setIsLeaf( 0 );
        menu.setSeq( 2 );
        menu.setPid( "0" );
        menu.setStatus( 1 );
        menu.setDelFlag( NO_DEL_FLAG );

        Date today = new Date();
        menu.setUpdateTime( today );
        menu.setUpdator( "test01" );
        menu.setCreator( "test02" );
        menu.setCreateTime( today );

        User user = new User();
        user.setId( "test01" );
        user.setNickName( "test01" );
        user.setRealName( "test01" );
        user.setPassword( "test01" );
        user.setUserNo( "test01" );

        user.setDelFlag( NO_DEL_FLAG );
        user.setUpdateTime( today );
        user.setUpdator( "test01" );
        user.setCreator( "test02" );
        user.setCreateTime( today );

        menuService.add( menu, user );
    }

    @Test
    public void testDel() throws Exception{
        Menu menu = new Menu();
        menu.setId( "351d8b5884c84cd8b5df1436d78bd9d1" );

        menuService.del( menu );
    }
}

