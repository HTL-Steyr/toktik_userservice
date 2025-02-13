package htl.steyr.toktik_userservice.repository;

import htl.steyr.toktik_userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Repository for User entities
 * @see User
 */
public interface UserRepository extends JpaRepository<User, UUID> {
}
