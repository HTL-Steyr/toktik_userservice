package htl.steyr.toktik_userservice.repository;

import htl.steyr.toktik_userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository for User entities
 *
 * @see User
 */
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUsernameOrEmail(String username, String email);

    User findByEmail(String email);

    User findByToken(String token);
}
