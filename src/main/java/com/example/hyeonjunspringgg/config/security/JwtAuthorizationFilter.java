package com.example.hyeonjunspringgg.config.security;

import com.example.hyeonjunspringgg.config.security.jwt.JwtTokenValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;


@RequiredArgsConstructor
@Slf4j
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final JwtTokenValidator jwtTokenValidator;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Optional<Cookie[]> cookies = Optional.ofNullable(request.getCookies());

        Arrays.stream(cookies.orElse(new Cookie[]{}))
                .filter(cookie -> cookie.getName()
                        .equals("access_token"))
                .findFirst()
                .ifPresent(cookie -> {
                    Authentication auth = jwtTokenValidator.getAuthenticationToAuthentication(cookie.getValue());
                    SecurityContextHolder.getContext().setAuthentication(auth);
                });

        filterChain.doFilter(request, response);
    }
}
