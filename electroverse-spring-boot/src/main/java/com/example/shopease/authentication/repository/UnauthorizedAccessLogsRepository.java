package com.example.shopease.authentication.repository;

import com.example.shopease.authentication.model.UnauthorizedAccessLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnauthorizedAccessLogsRepository extends JpaRepository<UnauthorizedAccessLogs,Long> {
}