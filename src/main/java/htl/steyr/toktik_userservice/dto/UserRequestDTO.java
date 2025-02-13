package htl.steyr.toktik_userservice.dto;

import htl.steyr.toktik_userservice.model.User;

/**
 * Data Transfer Object for UserRequest.
 *
 * @param usernameOrEmail String containing the username or email
 * @param password        String containing the password
 *
 * @see User
 * @see UserResponseDTO
 * @version 1.0
 */
public record UserRequestDTO(String usernameOrEmail, String password) {
}
