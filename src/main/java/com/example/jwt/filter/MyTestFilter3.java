package com.example.jwt.filter;


import com.example.jwt.util.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.http.HttpRequest;

@Slf4j

public class MyTestFilter3 implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;



        if(httpServletRequest.getMethod().equals("POST")){
            String authorization = httpServletRequest.getHeader("Authorization");
            if(authorization.equals("mytoken")){
                chain.doFilter(request, response);
                httpServletResponse.addHeader("Authorization", JwtTokenUtils.generateToken());
            }else{
                throw new IllegalArgumentException("응 안돼~");
            }
        }

        log.info("=======PRE ===MyTestFilter3");
    }
}
