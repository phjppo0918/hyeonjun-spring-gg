package com.example.hyeonjunspringgg.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter
@NoArgsConstructor
/**
 * @author 현준
 */
public class User implements UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @Setter
    private Long id;

    private String accountId;
    // default -> phjppo0918
    // social -> "id" or "at_hash"
    private String email; // ex@ex.com?
    private String password;
    private String name;
    private String nickname;
    private Integer age;

    private boolean isAdult = false;

    @Enumerated(EnumType.STRING)
    private AuthProvider authProvider = AuthProvider.NONE;

    @Enumerated(EnumType.STRING)
    private Authority authority = Authority.ROLE_USER;

    @Embedded
    private BaseTimeEntity baseTimeEntity = new BaseTimeEntity();

    /**
     *
     * @param accountId : 계정명
     * @param email : 이메일
     * @param password : 비밀번호
     * @param name : 이름
     * @param nickname : 닉네임
     * @param age : 나이
     * @param authProvider : 회원가입 방식
     */
    @Builder
    public User(String accountId,String email, String password, String name, String nickname, Integer age, AuthProvider authProvider) {
        this.accountId=accountId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.age = age;
        this.authProvider = authProvider;
    }
    public void update() {
        baseTimeEntity.update();
    }
    public void delete() {
        baseTimeEntity.delete();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(this.authority.name()));
        return grantedAuthorities;
    }

    @Override
    public String getUsername() {
        return accountId;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
