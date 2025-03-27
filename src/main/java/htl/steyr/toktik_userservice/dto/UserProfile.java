package htl.steyr.toktik_userservice.dto;

import htl.steyr.toktik_userservice.model.Gender;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public record UserProfile(UUID id, String username, String firstName, String lastName, Gender gender, String email,
                          LocalDate birthday) {
}
