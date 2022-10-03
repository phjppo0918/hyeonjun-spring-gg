package com.example.hyeonjunspringgg.config.security;

import com.example.hyeonjunspringgg.config.security.jwt.JwtTokenValidator;
import com.example.hyeonjunspringgg.service.oauth2.OAuthUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final OAuthUserService oAuthUserService;
    private final OAuth2SuccessHandler successHandler;

    private final JwtTokenValidator jwtTokenValidator;

    private final AccessPoint accessPoint;


    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests()
                //.antMatchers("/**").permitAll()
                .antMatchers(HttpMethod.GET, accessPoint.GET_WHITELIST()).permitAll() // 해당 GET URL은 모두 허용
                .antMatchers(HttpMethod.POST, accessPoint.POST_WHITELIST()).permitAll() // 해당 POST URL은 모두 허용
                .antMatchers(accessPoint.ADMIN_ACCESSLIST()).hasRole("ADMIN")
                .antMatchers(accessPoint.MEMBER_ACCESSLIST()).hasRole("USER")
                .anyRequest().authenticated() // 그 외 요청은 권한 필요
                .and()
                .formLogin().disable()
                .httpBasic().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(corsFilter())
                .addFilterBefore(new JwtAuthorizationFilter(jwtTokenValidator), UsernamePasswordAuthenticationFilter.class)
                .oauth2Login()
                    .authorizationEndpoint()
                    .baseUri("/api/oauth2")
                    .and()
                    .successHandler(successHandler)
                    .userInfoEndpoint()
                    .userService(oAuthUserService)
                    .and()
                .and()
                .csrf().disable()
                .cors()
                .and().build();
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOriginPattern("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

   // @Bean
   // public JwtAuthorizationFilter jwt Filter() {
       // return new JwtAuthorizationFilter(jwtTokenValidator);
 //   }

}
