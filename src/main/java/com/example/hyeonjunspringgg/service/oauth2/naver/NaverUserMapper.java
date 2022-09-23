package com.example.hyeonjunspringgg.service.oauth2.naver;

import com.example.hyeonjunspringgg.dto.oauth2.OAuthUserDTO;
import com.example.hyeonjunspringgg.entity.AuthProvider;
import com.example.hyeonjunspringgg.entity.Authority;
import com.example.hyeonjunspringgg.entity.User;
import com.example.hyeonjunspringgg.service.oauth2.UserMapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class NaverUserMapper implements UserMapper {

    @Override
    public OAuthUserDTO mapToDTO(Map<String, Object> attributes) {

        Map<String, Object> response =
                (Map<String, Object>)attributes.get("response");

        String accountId = (String)response.get("id");
        String name = (String)response.get("name");
        String email = (String)response.get("email");
        return new OAuthUserDTO(accountId, name, email, AuthProvider.NAVER);
    }

    @Override
    public Map<String, Object> mapToTokenAttribute(User user) {
        Map<String, Object> result = new HashMap<>();
        result.put("id", user.getId());
        result.put("accountId", user.getAccountId());
        result.put("nickname", user.getNickname());
        result.put("role", Authority.ROLE_USER);
        return result;
    }

}
