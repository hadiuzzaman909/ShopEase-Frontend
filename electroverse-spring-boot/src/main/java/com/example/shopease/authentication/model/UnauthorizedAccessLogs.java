package com.example.shopease.authentication.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "unauthorized_access_logs")
public class UnauthorizedAccessLogs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "attempted_api")
    private String attemptedApi;

    @Column(name = "timestamp")
    private Instant timestamp;

    @Column(name = "reason")
    private String reason;

    @Column(name = "user_agent")
    private String userAgent;

    @Column(name = "ip_address")
    private String ipAddress;
}