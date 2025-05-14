package com.example.shopease.authentication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "phone_number")
    private String phoneNumber;

    @NotNull
    @Column(name = "email", unique = true)
    private String email;

    @NotNull
    @Column(name = "username", unique = true)
    private String username;

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "is_active")
    private boolean isActive;

    @NotNull
    @Column(name = "is_verified")
    private boolean isVerified;

    @Column(name = "failed_attempts")
    private int failedAttempts;

    @Column(name = "lock_time")
    private LocalDateTime lockTime;

    @Column(name = "force_password_change")
    private boolean forcePasswordChange;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @JsonIgnore
    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn
    private RefreshToken token;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    @JsonIgnore
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @PrimaryKeyJoinColumn
    private UserConfirmation userConfirmation;

    public boolean isTimedOut(Duration lockTimeDuration) {
        if (null != lockTime) {
            var unlockTime = getLockTime().plus(lockTimeDuration);
            return unlockTime.isBefore(LocalDateTime.now());
        }
        return false;
    }

    @Column(name = "full_name", length = 300)
    private String fullName;

    @PrePersist
    @PreUpdate
    private void updateFullName() {
        StringBuilder sb = new StringBuilder();

        if (firstName != null) {
            sb.append(firstName.trim());
        }

        if (middleName != null && !middleName.trim().isEmpty()) {
            sb.append(" ").append(middleName.trim().toLowerCase());
        }

        if (lastName != null) {
            sb.append(" ").append(lastName.trim());
        }

        this.fullName = sb.toString().trim();
    }

}