package htl.steyr.toktik_userservice.dto;

import java.time.LocalDate;

public record SignupRequest(String username, String email, String password, LocalDate birthday) {}
