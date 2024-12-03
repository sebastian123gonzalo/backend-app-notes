package com.api.backend.login.domain.service;

import com.api.backend.login.domain.model.User;
import com.api.backend.login.domain.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512); //Generar una clave secreta

    @Autowired
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String login(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty() || !userOptional.get().getPassword().equals(password)) {
            return null;
        }

        User user = userOptional.get();
        return generateToken(user);
    }



    private String generateToken(User user) {
        long expirationTime = 86400000;
        return Jwts.builder()
                .setClaims(Map.of("sub", user.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(secretKey)
                .compact();
    }

    public boolean verifyToken(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return claims.getExpiration().after(new Date());
        } catch (Exception e) {
            return false;
        }
    }
}