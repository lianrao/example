package com.rda.example.jwt;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

/**
 * Created by admin on 2015/12/11.
 */

@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
            register(JacksonFeature.class);

            register(JwtController.class);
            register(RestController.class);
        }
}
