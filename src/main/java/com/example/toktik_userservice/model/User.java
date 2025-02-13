package com.example.toktik_userservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @NonNull
    private String username;

    @NonNull
    private String vorname;

    @NonNull
    private String nachname;

    @NonNull
    private LocalDate birthday;

    @NonNull
    private String email;

    // TODO: rest of attributes
}
