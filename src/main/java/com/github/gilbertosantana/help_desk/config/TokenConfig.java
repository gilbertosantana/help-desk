package com.github.gilbertosantana.help_desk.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.github.gilbertosantana.help_desk.entities.User;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Component
public class TokenConfig {

    private final JWTProperties secret;

    public TokenConfig(JWTProperties secret) {
        this.secret = secret;
    }

    public String generateToken(User user) {
        Algorithm algorithm = Algorithm.HMAC256(secret.getSecret());

        return JWT.create()
                .withClaim("userId", user.getId())
                .withClaim("profiles", user.getProfiles().stream().map(Enum::name).toList())
                .withSubject(user.getEmail())
                .withExpiresAt(Instant.now().plusSeconds(86400))
                .withIssuedAt(Instant.now())
                .sign(algorithm);
    }

    public Optional<JWTUserData> validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret.getSecret());
            DecodedJWT decode = JWT.require(algorithm)
                    .build()
                    .verify(token);

            return Optional.of(JWTUserData.builder()
                    .userId(decode.getClaim("userId").asLong())
                    .email(decode.getSubject())
                    .profiles(decode.getClaim("profiles").asList(String.class))
                    .build());
        } catch (JWTVerificationException ex) {
            return Optional.empty();
        }
    }
}
