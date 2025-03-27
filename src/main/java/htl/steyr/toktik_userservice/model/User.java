package htl.steyr.toktik_userservice.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

///**
// * A user entity that represents a user in the database.
// * This is used to store user information in the application.
// */
//@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//@ToString
//@Table(name = "user")
//public class User {
//    /**
//     * The unique identifier of the user.
//     * This is used to identify the user in the database.
//     * This is set automatically when the user is created.
//     * @see UUID
//     */
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    @Column(nullable = false)
//    private UUID id;
//
//    /**
//     * A unique username for the user.
//     * This is used for login.
//     */
//    @Column(nullable = false, unique = true)
//    private String username;
//
//    /**
//     * The first name of the user.
//     */
//    @Column(nullable = false)
//    private String firstName;
//
//    /**
//     * The last name of the user.
//     */
//    @Column(nullable = false)
//    private String lastName;
//
//    /**
//     * The biography of the user.
//     * Is optional.
//     */
//    @Column()
//    private String biography;
//
//    /**
//     * The birthday of the user.
//     * This is used to calculate the age of the user.
//     * The age of the user is not stored in the database.
//     */
//    @Column(nullable = false)
//    private LocalDate birthday;
//
//    /**
//     * The email address of the user.
//     * This is used for login.
//     */
//    @Column(nullable = false, unique = true)
//    private String email;
//
//    /**
//     * The gender of a user.
//     * This is used to address the user correctly.
//     * @see Gender
//     */
//    @Column(nullable = false)
//    private Gender gender;
//
//    /**
//     * The password of the user.
//     * This is used for login.
//     * The password is hashed before it is stored in the database.
//     */
//    @Column(nullable = false)
//    @ToString.Exclude
//    private String password;
//
//    /**
//     * Timestamp when the user was created.
//     * This is used to track when the user was created.
//     * This is set automatically when the user is created.
//     */
//    @CreationTimestamp
//    @Column(nullable = false, updatable = false)
//    private Instant createdAt;
//}
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private LocalDate birthday;

    private String token;
}