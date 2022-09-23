package com.example.hyeonjunspringgg.config.security.jwt;

import com.example.hyeonjunspringgg.dto.AuthResponseDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
@RequiredArgsConstructor
public class JwtTokenValidator {

    private final Key key;

    public AuthResponseDTO getAuthentication(String accessToken) {
        Claims claims = getTokenBodyClaims(accessToken);

        return new AuthResponseDTO(claims);
    }

    private Claims getTokenBodyClaims(String accessToken) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(accessToken)
                .getBody();
    }

}
