package com.example.toktik_userservice.controller;

import com.example.toktik_userservice.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class UserController {
    @NonNull
    private UserService userService;
}
