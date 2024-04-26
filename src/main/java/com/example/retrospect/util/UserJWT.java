package com.example.retrospect.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component

public class UserJWT {
    private static final String SECRET = "retrospect";

    public String generateToken(Long userId) {
        return JWT.create()
                .withClaim("userId" ,userId)
                .sign(Algorithm.HMAC256(Base64.getEncoder().encode(SECRET.getBytes())));
    }

    public long decodeToken(String token) {

            long userId = JWT.require(Algorithm.HMAC256(Base64.getEncoder().encode(SECRET.getBytes())))
                    .build()
                    .verify(token)
                    .getClaim("userId")
                    .asLong();
            return userId;


        }
        }


