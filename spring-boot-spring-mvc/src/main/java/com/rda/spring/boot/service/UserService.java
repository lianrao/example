package com.rda.spring.boot.service;

import com.rda.spring.boot.mapper.UserMapper;
import com.rda.spring.boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by admin on 2016/2/1.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public User getUser(){
        return userMapper.getById(1);
    }

}
