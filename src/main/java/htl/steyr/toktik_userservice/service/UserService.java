package htl.steyr.toktik_userservice.service;

import htl.steyr.toktik_userservice.dto.AuthResponse;
import htl.steyr.toktik_userservice.dto.LoginRequest;
import htl.steyr.toktik_userservice.dto.SignupRequest;
import htl.steyr.toktik_userservice.model.User;
import htl.steyr.toktik_userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;

    public AuthResponse signup(SignupRequest request) {
        User user = User.builder()
                .username(request.username())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .birthday(request.birthday())
                .build();
        userRepository.save(user);
        String token = jwtService.generateToken(user.getUsername());
        return new AuthResponse(token);
    }

    public AuthResponse login(LoginRequest request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.usernameOrEmail(), request.password()));
        User user = userRepository.findByUsername(request.usernameOrEmail());
        String token = jwtService.generateToken(user.getUsername());
        return new AuthResponse(token);
    }

    public boolean verifyUser(String token) {
        return jwtService.isValid(token);
    }
}
