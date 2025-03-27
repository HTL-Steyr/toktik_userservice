package htl.steyr.toktik_userservice.dto;

import htl.steyr.toktik_userservice.model.Gender;

import java.time.Instant;
import java.time.LocalDate;

public record SignupRequest(String username, String firstname, String lastname, String password, Gender gender, String email,
                            LocalDate birthday, Instant createdAt) {}
