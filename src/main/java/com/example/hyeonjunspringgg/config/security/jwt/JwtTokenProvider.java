package com.example.hyeonjunspringgg.config.security.jwt;

import com.example.hyeonjunspringgg.dto.AuthResponseDTO;
import com.example.hyeonjunspringgg.dto.JWTTokenDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
    private final Key hashKey;
    private final Long ACCESS_TOKEN_VALIDATION_SECOND = 60L * 60 * 24 * 1000;
    private final Long REFRESH_TOKEN_VALIDATION_SECOND = 60L * 60 * 24 * 14 * 1000;

    public JWTTokenDTO createJWTTokens(AuthResponseDTO user) {
        Claims claims = getClaims(user);

        String accessToken = getToken(user, claims, ACCESS_TOKEN_VALIDATION_SECOND);
        String refreshToken = getToken(user, claims, REFRESH_TOKEN_VALIDATION_SECOND);

        return JWTTokenDTO.builder()
                .grantType("bearer")
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    public String reissueAccessToken(AuthResponseDTO user){
        Claims claims = getClaims(user);
        return getToken(user, claims, ACCESS_TOKEN_VALIDATION_SECOND);
    }

    private Claims getClaims(AuthResponseDTO user) {
        Claims claims = Jwts.claims();
        claims.put("id", user.getId());
        claims.put("accountId", user.getAccountId());
        claims.put("nickname", user.getNickname());
        claims.put("role", user.getRole());

        return claims;
    }

    /**
     *
     * @param user
     * @param claims
     * @param validationSecond
     * @return
     */

    private String getToken(AuthResponseDTO user, Claims claims, Long validationSecond) {
        long now = new Date().getTime();

        return Jwts.builder()
                .setSubject(user.getAccountId())
                .setClaims(claims)
                .signWith(hashKey, SignatureAlgorithm.HS512)
                .setExpiration(new Date(now + validationSecond))
                .compact();
    }
}
