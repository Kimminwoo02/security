package com.example.jwt.exam;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

// auth0 : java - jwt 라이브러리
public class JwtTest2 {
    // JWT - Create
    public static void main(String[] args) {

        // JWT 스펙게서 정의한 클레임을 추가할 수 있다.

        // iss : 토큰을 발행한 단체나 사이트가 누구인지?
        // sub : 어떤 주제에 대한 토큰인지
        // jti : 토큰 일련번호
        // exp : 토큰 만료 시간


        String oauth_token = JWT.create()
                .withClaim("name", "minu")
                .withClaim("id","hello")
                .sign(Algorithm.HMAC256("hello"));

        System.out.println(oauth_token);
        jwtTest1.printToken(oauth_token);

        // 파싱
        JWTVerifier hello = JWT.require(Algorithm.HMAC256("hello")).build();
        DecodedJWT verify = hello.verify(oauth_token);
        System.out.println(verify);


    }


}
