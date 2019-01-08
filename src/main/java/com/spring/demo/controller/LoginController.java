package com.spring.demo.controller;

import com.spring.demo.model.User;
import com.spring.demo.service.IUserService;
import com.spring.demo.utils.FastJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/doLogin")
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
