package com.example.hyeonjunspringgg.config.security;

import org.springframework.stereotype.Component;

@Component

public class AccessPoint {

    private String GET_WHITELIST[] = new String[] {
    };

    private String POST_WHITELIST[] = new String[] {
            "/api/login/**",
            "/api/user/**"
    };

    private String ADMIN_ACCESSLIST[] = new String[] {
            "/api/admin/**"
    };

    private String MEMBER_ACCESSLIST[] = new String[] {
            "api/auth/**",
            "/api/member/**"
    };

    public String[] GET_WHITELIST() {
        return GET_WHITELIST;
    }

    public String[] POST_WHITELIST() {
        return POST_WHITELIST;
    }

    public String[] ADMIN_ACCESSLIST() {
        return ADMIN_ACCESSLIST;
    }

    public String[] MEMBER_ACCESSLIST() {
        return MEMBER_ACCESSLIST;
    }
}
