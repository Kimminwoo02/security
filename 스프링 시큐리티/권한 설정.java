권한 설정
1. 선언적 방식
 - URL : http.antMatcher("/users/**").hasRole("USER")
 - Method : @PreAuthorize("hasRole(USER)")      public void user({System.out.println("user")})

2. 동적 방식 -DB 연동 프로그래밍 
 - URL
 - Method

 @Override
 protected void configure (HttpSecurity http) throws Exception{
    http
        .antAmatcher("/shop/**")
        .authorizeRequests()
            .antMatchers("/shop/login","/shop/users/**").permitAll()
            .antMatchers("/shop/mypage").hasRole("USER")
            .antMatchers("/shop/admin/pay").access("hasRole('ADMIN')");
            .antMatcher("/shop/admin/**").access("hasRole('ADMIN')") or hasRole('SYS')""); 
            .anyRequest().authenticated()


 }

 메소드 
 authenticated() : 인증된 사용자의 접근을 허용
 fullyAuthenticated() : 인증된 사용자의 접근을 허용, reMemberMe 인증 제외
 permitAll() : 무조건 접근 허용
 denyAll() : 무조건 접근을 허용하지 않음
 anonymous() : 익명사용자의 접근을 허용
 rememberMe() : 기억하기를 통해 인증된 사용자의 접근을 허용
 access(String) 주어진 SpEl 표현식의 평가 결과가 true이면 접근을 허용
 hasRole(String) 사용자가 주어진 역할이 있다면 접근을 허용
 hasAuthority(String) : 사용자가 주어진 권한이 있다면 접근을 허용
 hasAnyRole(String...) 사용자가 주어진 권한이 있다면 접근을 허용
 hasAnyAuthority(String...) 사용자가 주어진 권한 중 어떤 것이라도 있다면 접근을 허용
 hasIpAddress(String) 주어진 IP로부터 요청이 왔다면 접근을 허용

 사용자 생성은 AuthenticationManagerBuilder로 한다.
 auth.inMermoryAuthentication().withUser("user").password("1111").roles("USER"); //사용자 계정 생성 권한은 유저
 auth.inMermoryAuthentication().withUser("sys").password("1111").roles("SYS","USER"); //사용자 계정 생성 권한은 유저
 auth.inMermoryAuthentication().withUser("admin").password("1111").roles("ADMIN","SYS","USER"); //사용자 계정 생성 권한은 유저 


 antMatcher("/user").hasRole("USER")   //유저로 접근하는 요청에 대해서 매칭이 된다면
 antMatcher("/admin/pay").hasRole("ADMIN")   //유저로 접근하는 요청에 대해서 매칭이 된다면
 antMatcher("/admin/**").access("hasRole('ADMIN') or hasRole('SYS')")   //유저로 접근하는 요청에 대해서 매칭이 된다면