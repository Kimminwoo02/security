스프링 시큐리티
기본 API

WebSecuriotyConfgigurerAdapter : 스프링 시큐리티의 웹 보안 기능 초기화 및 설정 이 클래스는 HTTPSecurity를 생성하고 세부적인 보안 설정이 가능하다.
(의존성 추가만해도 이 두 가지가 생긴다.)

SecurtiyConfig

@Configuration
@EnbableWebSecurity
public class SecurityConfig extends WebSecuritryConfigurerAdapter{
    
    @Overrdide
    protected void configure(HttpSecurity http) throws Exception{
        http
            .authorizeRequests()
            .anyRequest().authenticated()
        .and()
            .formLogin();
    }
}

HttpSecurity는  webSecurityConfigurere를 상속받고 있다. 
이 안에서 인증, 인가가 이루어진다.

httpSecurity를 생성하면 11개 정도의 api를 호출하고 설정하게 된다.

configure
http
    .authorizeRequests() : 보안설정, anyRequest.authenticated 도 보안설정
    .formLogin.and
    .httpBasic () : 인증방식으로 formLogin방식과 httpBasic방식을 제공한다.

 @Override
 protected void configure(HttpSecurity http) throws Exception{
    http
        .authorizeRequest()
        .anyRequest().authenticated(); // 어떤 요청에도 인증을 받도록 한다.
    http
        .formLogin()
    ;
 }

 환경설정에 패스워드를 직접 지정해줄 수 있다.
 application.property
 - spring.security.user.name=user
 - spring.security.user.password=1111
 

 formLogin