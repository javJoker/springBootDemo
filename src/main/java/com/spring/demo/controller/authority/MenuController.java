package com.spring.demo.controller.authority;

import com.spring.demo.constant.RedisConstant;
import com.spring.demo.exception.DemoException;
import com.spring.demo.model.authority.Menu;
import com.spring.demo.model.user.User;
import com.spring.demo.service.authority.IMenuService;
import com.spring.demo.service.common.IRedisService;
import com.spring.demo.utils.CtokenUtil;
import com.spring.demo.utils.LogUtil;
import com.spring.demo.utils.RedisUtil;
import com.spring.demo.vo.ReturnVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.spring.demo.constant.BaseConstant.*;

@RestController
@RequestMapping("/demo/authority/menu")
public class MenuController {

    private Logger LOG =  Logger.getLogger(MenuController.class);

    @Autowired
    private IRedisService redisService;

    @Autowired
    private IMenuService menuService;

    // 查询
    @RequestMapping("/ajaxList")
    public Object ajaxList(){
        ReturnVo returnVo = new ReturnVo(ERROR, "查询失败！");
        try {

            Menu menu = new Menu();
            menu.setDelFlag( NO_DEL_FLAG );
            List<Menu> menuList = menuService.getAll( menu );
            // 根据sessionId获取用户信息
//            String ctoken = CtokenUtil.getCtoken( request );
//            redisService.set( RedisUtil.formatRedisKey( RedisConstant.SESSION, ctoken ), userByUserNo );
//            User user = redisService.get( RedisUtil.formatRedisKey( RedisConstant.SESSION, ctoken ), User.class );

            returnVo = new ReturnVo(SUCCESS, "查询成功！",menuList);
        } catch (Exception e) {
            LogUtil.error(LOG, e, "菜单查询失败");
        }
//        return  FastJsonUtil.convertObjectToJSON(returnVo);
        return  returnVo;
    }

    // 添加
    @RequestMapping("/add")
    public Object add(HttpServletRequest request, Menu menu){
        ReturnVo returnVo = new ReturnVo(ERROR, "添加失败！");
        try {

            // 检查必填项是否为空
            String menuName = menu.getName();
            String menuSn = menu.getSn();
            Integer menuSeq = menu.getSeq();
            Integer menuIsleaf = menu.getIsLeaf();
            Integer status = menu.getStatus();
            Boolean someStringNull = isSomeStringNull( menuName, menuSn, menuSeq.toString(), menuIsleaf.toString(), status.toString() );
            if (someStringNull){
                LogUtil.error(LOG, "必填项不能为空");
                throw new DemoException( "菜单必填字段不能为空" );
            }

            menu.setDelFlag( NO_DEL_FLAG );

            // 根据sessionId获取用户信息
            String ctoken = CtokenUtil.getCtoken( request );
            User user = redisService.get( RedisUtil.formatRedisKey( RedisConstant.SESSION, ctoken ), User.class );
            menuService.add( menu, user );

            returnVo = new ReturnVo(SUCCESS, "添加成功！");
        } catch (Exception e) {
            LogUtil.error(LOG, e, "菜单添加失败");
        }
//        return  FastJsonUtil.convertObjectToJSON(returnVo);
        return  returnVo;
    }

    /**
     * 判断可变参数中是否其中某个为空
     * @param str
     * @return
     */
    private Boolean isSomeStringNull(String ...str){
        Boolean isNull = Boolean.FALSE;
        for (String temp : str){
            if (StringUtils.isBlank( temp ) && temp.length() == 0){
                isNull = Boolean.TRUE;
                break;
            }
        }
        return isNull;
    }

}
