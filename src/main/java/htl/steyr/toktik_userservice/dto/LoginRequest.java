package htl.steyr.toktik_userservice.dto;

import jakarta.annotation.Nullable;

public record LoginRequest(@Nullable String username, @Nullable String email, String password) {}
