package htl.steyr.toktik_userservice.dto;

import htl.steyr.toktik_userservice.model.Gender;
import htl.steyr.toktik_userservice.model.User;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Data Transfer Object for UserResponse.
 * The password is not included in the response DTO.
 *
 * @param id        UUID containing the id
 * @param username  String containing the username
 * @param firstName String containing the first name
 * @param lastName  String containing the last name
 * @param birthday  LocalDate containing the birthday
 * @param email     String containing the email
 * @param gender    Enum value containing the gender
 *
 * @see User
 * @see UserRequestDTO
 * @version 1.0
 */
public record UserResponseDTO(
        UUID id,
        String username,
        String firstName,
        String lastName,
        LocalDate birthday,
        String email,
        Gender gender
) {
}
