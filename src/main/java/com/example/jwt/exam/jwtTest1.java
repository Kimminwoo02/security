package com.example.jwt.exam;

// okta의 토큰 만들기

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Base64;
import java.util.Map;

public class jwtTest1 {
    public  static void printToken(String token){
        String[] splitdata = token.split("\\.");
        System.out.println("header:" + new String(Base64.getDecoder().decode(splitdata[0])));
        System.out.println("payload:" + new String(Base64.getDecoder().decode(splitdata[1])));
        //System.out.println("signature:" + new String(Base64.getDecoder().decode(splitdata[2])));

    }
    public static void main(String[] args) {
        //jjwt를 이용한 토큰 사용
        // Jwts가 builder 패턴이 적용된 객체 - 토큰을 만들 때 사용하는 빌더
        String okta_jwt_token = Jwts.builder()
                .addClaims(Map.of("name","bts", "id","minu"))

                // 서명
                .signWith(SignatureAlgorithm.HS256, "minu")
                .compact();

        System.out.println(okta_jwt_token);
        printToken(okta_jwt_token);


        // 토큰 파싱하기
        Jws<Claims> tokenInfo = Jwts.parser().setSigningKey("minu")
                .parseClaimsJws(okta_jwt_token);
        System.out.println("===================");
        System.out.println(tokenInfo);

        // JWTS(okta) 라이브러리로 oauth 라이브러리로 만들어진 토큰(oauth_token)을 파싱

        JWTVerifier hello = JWT.require(Algorithm.HMAC256(okta_jwt_token)).build();
        DecodedJWT verify = hello.verify( okta_jwt_token);
        System.out.println(verify);


    }
}
