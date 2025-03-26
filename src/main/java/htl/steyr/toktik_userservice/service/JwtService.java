package htl.steyr.toktik_userservice.service;

import htl.steyr.toktik_userservice.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Service
public class JwtService {
    private final String SECRET_KEY = "a5fd520e0f9f5d78c6e4c2ca684be57a46e43e4d5a13dc51bd8a719dca26a19e";
    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    public String generateToken(User user) {
        return Jwts.builder()
                .claim("user", user.getUsername())
                .id(String.valueOf(user.getId()))
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(key)
                .compact();
    }

    public boolean isValid(String token) {
        return Jwts.parser().verifyWith((SecretKey) key).build().isSigned(token);
    }
}
