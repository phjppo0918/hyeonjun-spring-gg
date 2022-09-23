package com.example.hyeonjunspringgg.dto.oauth2;

import com.example.hyeonjunspringgg.entity.AuthProvider;
import com.example.hyeonjunspringgg.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class OAuthUserDTO {
    private String accountId;
    private String name;
    @Setter
    private String nickname;
    private String email;
    private AuthProvider authProvider;

    public OAuthUserDTO(String accountId, String name, String email, AuthProvider authProvider) {
        this.accountId = accountId;
        this.name = name;
        this.email = email;
        this.authProvider = authProvider;
    }

    public User toEntity() {
        return User.builder()
                .accountId(accountId)
                .name(name)
                .nickname(nickname)
                .email(email)
                .authProvider(authProvider)
                .build();
    }
}
