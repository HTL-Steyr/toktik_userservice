package htl.steyr.toktik_userservice.service;

import htl.steyr.toktik_userservice.dto.AuthResponse;
import htl.steyr.toktik_userservice.dto.LoginRequest;
import htl.steyr.toktik_userservice.dto.SignupRequest;
import htl.steyr.toktik_userservice.dto.UserProfile;
import htl.steyr.toktik_userservice.model.User;
import htl.steyr.toktik_userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Service class for user authentication and management.
 * <p>
 * This service handles user signup, login, and token verification.
 */
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;

    /**
     * Signs up a new user and generates a JWT token.
     *
     * @param request the signup request containing user details
     * @return an AuthResponse containing the generated JWT token
     */
    public AuthResponse signup(SignupRequest request) {
        User user = User.builder()
                .username(request.username())
                .firstName(request.firstname())
                .lastName(request.lastname())
                .gender(request.gender())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .birthday(request.birthday())
                .createdAt(Instant.now())
                .build();

        userRepository.save(user);
        String token = jwtService.generateToken(user);
        user.setToken(token);
        userRepository.save(user);

        return new AuthResponse(token);
    }

    /**
     * Logs in a user and generates a JWT token.
     *
     * @param request the login request containing username or email and password
     * @return an AuthResponse containing the generated JWT token
     */
    public AuthResponse login(LoginRequest request) {
        if (request.username() != null) {
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.username(), request.password()));
        } else if (request.email() != null) {
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.email(), request.password()));
        } else {
            return null;
        }

        User user = userRepository.findByUsernameOrEmail(request.username(), request.email());
        String token = jwtService.generateToken(user);
        return new AuthResponse(token);
    }

    /**
     * Verifies the JWT token for user authentication.
     *
     * @param token the JWT token to verify
     * @return true if the token is valid, false otherwise
     */
    public boolean verifyUser(String token) {
        return jwtService.isValid(token);
    }

    public UserProfile getProfile(String uuid) {
        User user = userRepository.findById(UUID.fromString(uuid)).orElse(null);
        if (user != null) {
            return new UserProfile(
                    user.getId(),
                    user.getUsername(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getGender(),
                    user.getEmail(),
                    user.getBirthday());
        }
        return null;
    }
}
