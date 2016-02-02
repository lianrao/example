package com.rda.example.jwt;

import org.junit.Test;

/**
 * Created by admin on 2015/12/16.
 */
public class JwtControllerTest {

    @Test
    public void testJwt() throws Exception {

        String jwt = new JwtController().jwt();
        System.out.println("jwt:["+jwt + "];");

    }
}