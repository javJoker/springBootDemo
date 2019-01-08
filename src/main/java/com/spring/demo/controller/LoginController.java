package com.spring.demo.controller;

import com.spring.demo.model.user.User;
import com.spring.demo.service.user.IUserService;
import com.spring.demo.utils.FastJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/index")
    public String index(){
        return "/index";
    }

    @RequestMapping("/doLogin")
    @ResponseBody
    public String doLogin(){
        User user = null;
        try {
            user = userService.getUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return FastJsonUtils.convertObjectToJSON(user);
    }
}
