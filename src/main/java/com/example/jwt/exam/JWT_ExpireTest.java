package com.example.jwt.exam;

// 토큰의 만료시간 테스트

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class JWT_ExpireTest {
    public static void main(String[] args) throws InterruptedException {
        Algorithm algorithm = Algorithm.HMAC256("minu");

        //JWT 생성
        String token = JWT.create()
                .withSubject("bts")
                // 최소 1000ms 후에 실행하겠다는 소리
                .withNotBefore(new Date(System.currentTimeMillis()+ 1000))
                .withExpiresAt(new Date(System.currentTimeMillis()+3000))
                .sign(algorithm);

        Thread.sleep(5000);
        try{
            DecodedJWT decodedJWT = JWT.require(algorithm).build().verify(token);
            System.out.println(decodedJWT.getClaims());
        }catch (Exception e){
            System.out.println("유효하지 않은 토큰입니다!");
        }


    }
}
