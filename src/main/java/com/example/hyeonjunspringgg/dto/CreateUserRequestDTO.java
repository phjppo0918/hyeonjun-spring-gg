package com.example.hyeonjunspringgg.dto;

import com.example.hyeonjunspringgg.entity.User;
import lombok.Getter;
import lombok.Setter;

@Setter
public class CreateUserRequestDTO {
    @Getter
    private String accountId;
    @Getter
    private String password;
    private String email;
    private String name;
    private String nickname;
    private Integer age;

    public User toEntity() {
        return User.builder()
                .accountId(this.accountId)
                .email(this.email)
                .password(this.password)
                .age(this.age)
                .name(this.name)
                .nickname(this.nickname)
                .build();
    }
}
