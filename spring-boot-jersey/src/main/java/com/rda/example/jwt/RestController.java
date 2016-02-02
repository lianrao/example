package com.rda.example.jwt;

import com.rda.example.jwt.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by admin on 2015/12/15.
 */

@Path("/test")
public class RestController {

    @Autowired
    private HelloService helloService;

    @Path("/hello")
    @GET
    public String hello(){
        return "hello";
    }

    @Path("/service")
    @GET
    public String service(){
        return helloService.hello();
    }
}
