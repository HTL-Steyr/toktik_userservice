package htl.steyr.toktik_userservice.dto;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public record UserProfile(UUID id, String username, String email, LocalDate birthday) {}
