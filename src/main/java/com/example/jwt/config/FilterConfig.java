package com.example.jwt.config;


import com.example.jwt.filter.MyTestFilter1;
import com.example.jwt.filter.MyTestFilter2;
import com.example.jwt.filter.MyTestFilter3;
import com.example.jwt.filter.RequestFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


import javax.servlet.FilterRegistration;

@Configuration
public class FilterConfig {


    @Bean
    public FilterRegistrationBean<RequestFilter> makefilter4(){
        FilterRegistrationBean<RequestFilter> filter3 = new FilterRegistrationBean<>(new RequestFilter());
        filter3.addUrlPatterns("/*");
        filter3.setOrder(1);
        return filter3;

    }



    @Bean
    public CorsFilter corsFilter(){

        // 허용할 수 있는 부분 정의
        // UrlbaseCorsConfigurationSource 에 허용범위에 포함된 내용을 정의하고
        // 정의한 자원의 허용범위값을 config에 세팅
        // 어떤 요청범위에 대해서 설정할 것인지를 명시
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // json 서버 응답을 js에서 처리할 수 있도록 허용
        config.addAllowedOrigin("*"); // 모든 ip에 대해서 응답을 허용하겠다는 의미
        config.addAllowedMethod("*"); // 모든 HTTP Method를 허용하겠다는 것!
        config.addAllowedHeader("*"); // 모든 http header를 허용
        source.registerCorsConfiguration("/api/**",config);

        return new CorsFilter(source);
    }
}
