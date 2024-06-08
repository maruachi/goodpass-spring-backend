package com.goodchalk.goodpass.jwt;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JWTProvider {
    private final SecretKey secretKey;
    private final Long expiredMillisSeconds;

    public JWTProvider(@Value("${spring.jwt.secret}") String secret,
                       @Value("${spring.jwt.expiredSeconds}") Long expiredMillisSeconds) {

        this.secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), Jwts.SIG.HS256.key().build().getAlgorithm());
        this.expiredMillisSeconds = expiredMillisSeconds;
    }

    public String createJwt(String username, String role) {

        return Jwts.builder()
                .claim("username", username)
                .claim("role", role)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiredMillisSeconds))
                .signWith(secretKey)
                .compact();
    }
}
