package com.example.shopease.authentication.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "user_confirmations")
public class UserConfirmation {

    @Id
    @Column(name = "user_id")
    private Long id;

    @NotNull
    @Column(name = "value", length = 2000, columnDefinition = "TEXT")
    private String value;

    @Column(name = "expired_at", nullable = false)
    private Instant expiredAt;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
}