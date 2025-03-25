package htl.steyr.toktik_userservice.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {
    private final String SECRET_KEY = "a5fd520e0f9f5d78c6e4c2ca684be57a46e43e4d5a13dc51bd8a719dca26a19e";

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public boolean isValid(String token) {
        return true;
    }
}
