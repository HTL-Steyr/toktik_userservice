package htl.steyr.toktik_userservice.controller;

import htl.steyr.toktik_userservice.dto.AuthResponse;
import htl.steyr.toktik_userservice.dto.LoginRequest;
import htl.steyr.toktik_userservice.dto.SignupRequest;
import htl.steyr.toktik_userservice.dto.UserProfile;
import htl.steyr.toktik_userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
class AuthController {
    private final UserService userService;

    @PostMapping("/signup")
    public AuthResponse signup(@RequestBody SignupRequest request) {
        return userService.signup(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }

    @GetMapping("/me")
    public UserProfile getProfile(@RequestHeader("Authorization") String token) {
        return userService.getProfile(token);
    }
}
