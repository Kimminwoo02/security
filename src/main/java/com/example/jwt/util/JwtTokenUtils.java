package com.example.jwt.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class JwtTokenUtils{
    public static String generateToken(){

        return JWT.create()
                .withClaim("name","minu")
                .withExpiresAt(new Date(System.currentTimeMillis()+86400000))
                .sign(Algorithm.HMAC256("bts"));

    }

}
