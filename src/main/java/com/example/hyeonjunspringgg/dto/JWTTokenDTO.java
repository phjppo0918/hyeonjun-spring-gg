package com.example.hyeonjunspringgg.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class JWTTokenDTO {
    private String accessToken;
    private String refreshToken;
    private String grantType;
}
