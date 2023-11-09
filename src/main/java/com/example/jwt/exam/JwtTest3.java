package com.example.jwt.exam;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

import javax.xml.bind.DatatypeConverter;

// auth0 : java - jwt 라이브러리
public class JwtTest3 {
    // JWT - Create
    public static void main(String[] args) {
        // 시크릿키를 특정함수 적용해서 값을 변경하기 (해싱)
        byte[] SEC_KEY = DatatypeConverter.parseBase64Binary("minu");

        String ouath_token = JWT.create()
                .withClaim("name","bts")
                .withClaim("id","minu")
                .sign(Algorithm.HMAC256("minu"));



        // auth라이브러리로 파싱,
        JWTVerifier hello = JWT.require(Algorithm.HMAC256(SEC_KEY)).build();
        DecodedJWT verify = hello.verify(ouath_token);
        System.out.println(verify);



        // okta라이브러리로 파싱 - 시크림ㅅ키를 한 번 더 해싱해서 작업
        Jws<Claims> tokenInfo = Jwts.parser().setSigningKey("minu")
                .parseClaimsJws(ouath_token);

    }


}
