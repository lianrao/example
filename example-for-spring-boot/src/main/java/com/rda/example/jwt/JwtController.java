package com.rda.example.jwt;

import org.springframework.boot.actuate.health.Health;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by admin on 2015/12/11.
 */

@Path("/rest/jwt")
public class JwtController {
    @GET
    @Produces("application/json")
    public Health health() {
        return Health.up().build();
    }

}
