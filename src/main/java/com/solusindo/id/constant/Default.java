package com.solusindo.id.constant;

public class Default {
    public static final String USER = "SYSTEM";
    public static final String SOURCE = "SOLUSINDO";


    public static final String[] AUTH_WHITELIST = {
            "/v3/api-docs/**",
            "/actuator/**",
            "/swagger-ui/**",
            "/login/**",
            "/error"
    };
}
