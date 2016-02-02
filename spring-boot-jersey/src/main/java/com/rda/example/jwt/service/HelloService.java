package com.rda.example.jwt.service;

import org.springframework.stereotype.Service;

/**
 * Created by admin on 2015/12/16.
 */
@Service
public class HelloService {

    public String hello(){
        return "hello from service";
    }
}
