package com.spring.demo.controller;

import com.spring.demo.model.user.User;
import com.spring.demo.service.user.IUserService;
import com.spring.demo.utils.FastJsonUtils;
import com.spring.demo.vo.ReturnVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.spring.demo.constant.BaseConstant.ERROR;
import static com.spring.demo.constant.BaseConstant.NO_DEL_FLAG;

@RestController
public class LoginController {

    private Logger LOG =  Logger.getLogger(LoginController.class);

    @Autowired
    private IUserService userService;

    @RequestMapping("/doLogin")
    public String doLogin(User user){
        ReturnVo<User> returnVo = new ReturnVo<>(ERROR, "登录失败！");
        try {
//            user.setDelFlag(NO_DEL_FLAG);
            String password = user.getPassword();
            String userNo = user.getUserNo();
            if (StringUtils.isBlank(userNo) || StringUtils.isBlank(password)){
                returnVo = new ReturnVo<>(ERROR, "登录名、密码不能为空！");
            }else {
                User userByUserNo = userService.getUserByUserNo(user.getUserNo());
                if (null != user){
                    if (password == userByUserNo.getPassword()){
                        returnVo = new ReturnVo<>(ERROR, "登录成功！", userByUserNo, null);
                    }else {
                        returnVo = new ReturnVo<>(ERROR, "密码错误！");
                    }
                }else {
                    returnVo = new ReturnVo<>(ERROR, "用户不存在！");
                }
            }
        } catch (Exception e) {
//            LogUtil.error(LOG, e, "登录失败，userNo:{0}", user.getUserNo());
            LOG.error("登录失败，userNo:" + user.getUserNo() + e);
        }
        return FastJsonUtils.convertObjectToJSON(returnVo);
    }
}
