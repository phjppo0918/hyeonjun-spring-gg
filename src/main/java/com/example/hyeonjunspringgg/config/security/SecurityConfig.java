package com.example.hyeonjunspringgg.config.security;

import com.example.hyeonjunspringgg.service.oauth2.OAuthUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final OAuthUserService oAuthUserService;
    private final OAuth2SuccessHandler successHandler;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated() // 그 외 요청은 권한 필요
                .and()
                .formLogin().disable()
                .oauth2Login()
                    .authorizationEndpoint()
                    .baseUri("/api/oauth2")
                    .and()
                    .successHandler(successHandler)
                    .userInfoEndpoint()
                    .userService(oAuthUserService)
                    .and()
                .and().csrf()
                .and().cors()
                .and().build();


    }


}
