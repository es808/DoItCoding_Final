package com.example.finalpro;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests()
                .requestMatchers("/admin/**").hasRole("admin")
                .requestMatchers("/","/login","/signUp","/main","/detail","/search",
                        "/css/**","/images/**","/image/**","/**", "/db/**").permitAll()
                .anyRequest().authenticated();

        http.formLogin().loginPage("/login").permitAll()
                .failureUrl("/loginFailed")
                .defaultSuccessUrl("/main",true);        //로그인 성공 후 이동 페이지 true를 붙여서 붙여서 절대경로 설정


        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/main");

        http.httpBasic();

        return http.build();
    }
}
