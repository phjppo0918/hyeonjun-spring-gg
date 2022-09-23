package com.example.hyeonjunspringgg.dto;


import com.example.hyeonjunspringgg.entity.User;
import io.jsonwebtoken.Claims;
import lombok.Getter;

@Getter
public class AuthResponseDTO {
    public Long id;
    public String accountId;
    public String nickname;
    public String role;

    public AuthResponseDTO(User user) {
        this.id = user.getId();
        this.accountId = user.getAccountId();
        this.nickname = user.getNickname();
        this.role = user.getAuthority().name();
    }

    public AuthResponseDTO(Claims claims) {
        this.id = Long.parseLong(claims.get("id").toString());
        this.nickname = claims.get("nickname").toString();
        this.role = claims.get("role").toString();
    }

    public AuthResponseDTO(Long id, String accountId, String nickname, String role) {
        this.id = id;
        this.accountId = accountId;
        this.nickname = nickname;
        this.role = role;
    }
}
