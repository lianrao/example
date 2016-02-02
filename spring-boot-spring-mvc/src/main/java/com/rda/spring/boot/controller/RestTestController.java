package com.rda.spring.boot.controller;

import com.rda.spring.boot.model.User;
import com.rda.spring.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2016/1/28.
 */

@RestController
public class RestTestController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test.json")
    public String test(){
       return "test";
    }

    @RequestMapping("my")
    public String my(){
        return "my";
    }

    @RequestMapping("/user.json")
    public User user(){
        return userService.getUser();
    }
}
