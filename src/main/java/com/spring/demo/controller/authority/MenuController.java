package com.spring.demo.controller.authority;

import com.spring.demo.model.authority.Menu;
import com.spring.demo.service.authority.IMenuService;
import com.spring.demo.service.common.IRedisService;
import com.spring.demo.utils.LogUtil;
import com.spring.demo.vo.ReturnVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.spring.demo.constant.BaseConstant.ERROR;
import static com.spring.demo.constant.BaseConstant.SUCCESS;

@RestController
@RequestMapping("/demo/authority/menu")
public class MenuController {

    private Logger LOG =  Logger.getLogger(MenuController.class);

    @Autowired
    private IRedisService redisService;

    @Autowired
    private IMenuService menuService;

    @RequestMapping("/ajaxList")
    public Object ajaxList(String sessionId){
        ReturnVo returnVo = new ReturnVo(ERROR, "查询失败！");
        try {
            List<Menu> menuList = menuService.getAll();
            // 根据sessionId获取用户信息
//            User user = redisService.get( RedisUtil.formatRedisKey( RedisConstant.SESSION, sessionId ), User.class );
            returnVo = new ReturnVo(SUCCESS, "查询成功！",menuList);
        } catch (Exception e) {
            LogUtil.error(LOG, e, "查询失败，userNo:{0}");
        }
//        return  FastJsonUtil.convertObjectToJSON(returnVo);
        return  returnVo;
    }

}
