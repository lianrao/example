package com.rda.spring.boot.mapper;

import com.rda.spring.boot.model.User;

/**
 * Created by admin on 2016/2/1.
 */
public interface UserMapper {
    User getById(Integer id);
}
