package com.example.hyeonjunspringgg.dto;

import com.example.hyeonjunspringgg.entity.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserResponseDTO {
    private String accountId;
    private String email;
    private String name;
    private String nickname;
    private Integer age;

    public UserResponseDTO(User target) {
        this.email = target.getEmail();
        this.accountId = target.getEmail();
        this.age = target.getAge();
        this.nickname = target.getNickname();
        this.name = target.getName();
    }
}
