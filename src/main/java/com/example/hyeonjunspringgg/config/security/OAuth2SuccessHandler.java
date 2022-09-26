package com.example.hyeonjunspringgg.config.security;


import com.example.hyeonjunspringgg.config.security.jwt.JwtTokenProvider;
import com.example.hyeonjunspringgg.dto.AuthResponseDTO;
import com.example.hyeonjunspringgg.dto.JWTTokenDTO;
import com.example.hyeonjunspringgg.entity.Authority;
import com.example.hyeonjunspringgg.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@Component
@Slf4j
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final JwtTokenProvider jwtTokenProvider;

    private final AuthService authService;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException {

        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();

        String loginUserAccountId = oAuth2User.getAttribute("accountId");

        String loginUserRole = ((Authority)oAuth2User.getAttribute("role")).name();

        Long loginUserId =  oAuth2User.getAttribute("id");

        String loginUserNickname = oAuth2User.getAttribute("nickname");

        AuthResponseDTO user = new AuthResponseDTO(loginUserId, loginUserAccountId,loginUserNickname ,loginUserRole);
        JWTTokenDTO jwtTokenDto = jwtTokenProvider.createJWTTokens(user);

        authService.addJwtTokensInCookie(response, jwtTokenDto);

        response.sendRedirect("/");
    }
}
