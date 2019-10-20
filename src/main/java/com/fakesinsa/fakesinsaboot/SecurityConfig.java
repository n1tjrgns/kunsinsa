package com.fakesinsa.fakesinsaboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /*
    BCrypt 암호화 적용하는 방법.
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    */
    //뭘까
    @Autowired
    UserDetailsService userDetailsService;

    //뭘까
    @Autowired
    public void configure(AuthenticationManagerBuilder auth)throws Exception{
        auth.userDetailsService(userDetailsService);
    }

    /*@Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**","/scss/**","/vendor/**");

    }

    == //css , javascript, img  파일 로그인 없이도 접근가능
		.antMatchers("/css/**", "/js/**", "/img/**","/scss/**","/vendor/**").permitAll();
		이걸로 대체가능
    */

    //로그인 URL, 권한분리, logoutURL 등등 정의
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf()
                .disable() // http.csrf().disable() 웹 취약점인 csrf 공격을 막기 위한 설정.
                            //disable을 하지 않으면 해당 작업을 수행하기 위한 파라미터가 없다고 에러가 발생함
                           //HTTP Status 403 - Expected CSRF token not found. Has your session expired?

                .formLogin()
                .loginPage("/login")

        //css , javascript, img  파일 로그인 없이도 접근가능
                .and()
                .authorizeRequests()

                .antMatchers("/signup")
                .permitAll()

                .antMatchers("/css/**", "/js/**", "/img/**","/scss/**","/vendor/**")
                .permitAll();

                //위의 설정을 제외한 나머지는 인증 필요
                //이걸 설정하면 왜 리디렉션 횟수 초과 에러가 뜨지
                /*.anyRequest()
                .authenticated();*/

        //logout 설정
        http
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/index");
    }
}
