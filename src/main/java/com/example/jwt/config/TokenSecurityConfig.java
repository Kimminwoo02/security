package com.example.jwt.config;

import com.example.jwt.filter.MyTestFilter1;
import com.example.jwt.filter.MyTestFilter2;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

@EnableWebSecurity
@RequiredArgsConstructor
public class TokenSecurityConfig {

    private final CorsFilter corsFilter;

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
         http.sessionManagement(session->{
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                 })
                 .addFilter(corsFilter)

//                 .addFilterBefore(new MyTestFilter1(), CorsFilter.class)
//                 .addFilterAfter(new MyTestFilter1(), UsernamePasswordAuthenticationFilter.class) // 기존 필터들은 addFilter가 가능하지만 내가 만든 filter는 addBefore, addAfter 가 필요하다.
                 .csrf().disable()
                 .formLogin().disable()
                 .httpBasic().disable()
                 .authorizeRequests()
                  .antMatchers("/api/**")
                  .access("hasRole('USER') or hasRole('ADMIN')")
                  .antMatchers("/admin/api/**")
                  .access("hasRole('ADMIN')")
                  .anyRequest().permitAll();

                return http.build();
    }

}
