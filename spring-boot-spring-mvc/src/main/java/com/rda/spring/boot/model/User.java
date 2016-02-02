package com.rda.spring.boot.model;

/**
 * Created by admin on 2016/2/1.
 */
public class User {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id ;
    private String name;

}
