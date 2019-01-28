package com.spring.demo.controller;

import com.spring.demo.constant.RedisConstant;
import com.spring.demo.model.user.User;
import com.spring.demo.service.common.IRedisService;
import com.spring.demo.service.user.IUserService;
import com.spring.demo.utils.CtokenUtil;
import com.spring.demo.utils.FastJsonUtil;
import com.spring.demo.utils.LogUtil;
import com.spring.demo.utils.RedisUtil;
import com.spring.demo.vo.ReturnVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.spring.demo.constant.BaseConstant.*;

@RestController
@RequestMapping("/demo/login")
public class LoginController {

    private Logger LOG =  Logger.getLogger(LoginController.class);

    @Autowired
    private IRedisService redisService;

    @Autowired
    private IUserService userService;

    /**
     * 用户登录
     * @param user
     * @return
     */
    @RequestMapping("/doLogin")
    public String doLogin(HttpServletRequest request, HttpServletResponse response, User user){
        ReturnVo<User> returnVo = new ReturnVo<>(ERROR, "登录失败！");
        try {

//            user.setDelFlag(NO_DEL_FLAG);
            String password = user.getPassword();
            String userNo = user.getUserNo();
            if (StringUtils.isBlank(userNo) || StringUtils.isBlank(password)){
                LogUtil.info(LOG,"登录名、密码不能为空，userNo:{0}", userNo);
                returnVo = new ReturnVo<>(ERROR, "登录名、密码不能为空！");
            }else {
                User userByUserNo = userService.getUserByUserNo(user.getUserNo());
                if (null != userByUserNo){
                    if (password.equals(userByUserNo.getPassword())){
                        LogUtil.info(LOG,"登录名、密码不能为空，userNo:{0}", userNo);
                        returnVo = new ReturnVo<>(SUCCESS, "登录成功！", userByUserNo, null);
                        String ctoken = CtokenUtil.sendCtoken( request, response );
                        redisService.set( RedisUtil.formatRedisKey( RedisConstant.SESSION, ctoken ), userByUserNo );
                    }else {
                        LogUtil.info(LOG,"密码错误，userNo:{0}", userNo);
                        returnVo = new ReturnVo<>(ERROR, "密码错误！");
                    }
                }else {
                    LogUtil.info(LOG,"用户不存在，userNo:{0}", userNo);
                    returnVo = new ReturnVo<>(ERROR, "用户不存在！");
                }
            }
        } catch (Exception e) {
            LogUtil.error(LOG, e, "登录失败，userNo:{0}", user.getUserNo());
        }
        return FastJsonUtil.convertObjectToJSON(returnVo);
    }

    /**
     * 注册用户
     * @param user
     * @return
     */
    @RequestMapping("/doRegister")
    public String doRegister(User user){
        ReturnVo<User> returnVo = new ReturnVo<>(ERROR, "注册失败！");
        try {
            //查询注册的登录ID是否已经存在
            User userByUserNo = userService.getUserByUserNo( user.getUserNo() );
            if (null != userByUserNo){
                returnVo = new ReturnVo<>(ERROR, "登录名已经存在");
            }
            user.setDelFlag(NO_DEL_FLAG);
            userService.setUser(user);
            returnVo = new ReturnVo<>(ERROR, "注册成功");
        } catch (Exception e) {
            LogUtil.error(LOG, e, "注册失败，userNo:{0}", user.getUserNo());
        }
        return FastJsonUtil.convertObjectToJSON(returnVo);
    }
}
