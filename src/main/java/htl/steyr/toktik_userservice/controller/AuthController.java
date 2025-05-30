package htl.steyr.toktik_userservice.controller;

import htl.steyr.toktik_userservice.dto.AuthResponse;
import htl.steyr.toktik_userservice.dto.LoginRequest;
import htl.steyr.toktik_userservice.dto.SignupRequest;
import htl.steyr.toktik_userservice.dto.UserProfile;
import htl.steyr.toktik_userservice.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
class AuthController {
    @Autowired
    private final UserService userService;

    @PostMapping("/signup")
    public AuthResponse signup(@RequestBody SignupRequest request) {
        return userService.signup(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }

    @GetMapping("/me/{uuid}")
    public UserProfile getProfile(@PathVariable("uuid") String uuid) {
        return userService.getProfile(uuid);
    }

    @GetMapping
    public boolean authenticate(@RequestHeader("Authorization") String token){
        return userService.verifyUser(token);
    }
}
