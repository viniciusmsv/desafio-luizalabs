package com.luizalabs.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtil {

    private static final String key = "SECRET_TOKEN";

    public static final String USERNAME = "admin";
    public static final String PASSWORD = "admin";

    public static final String TOKEN_HEADER = "Authorization";

    public static String create(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
    }

    public static Jws<Claims> decode(String token) {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token);
    }
}
