package com.example.shopease.authentication.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "refresh_tokens")
public class RefreshToken {

    @Id
    @Column(name = "user_id")
    private Long id;

    @NotNull
    @Column(name = "value", length = 500)
    private String value;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
}