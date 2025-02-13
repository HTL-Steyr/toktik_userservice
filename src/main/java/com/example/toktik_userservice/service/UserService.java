package com.example.toktik_userservice.service;

import com.example.toktik_userservice.repository.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    @NonNull
    private UserRepository userRepository;
}
