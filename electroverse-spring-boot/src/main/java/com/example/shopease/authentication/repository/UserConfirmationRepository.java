package com.example.shopease.authentication.repository;

import com.example.shopease.authentication.model.UserConfirmation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserConfirmationRepository extends JpaRepository<UserConfirmation,Long> {
    UserConfirmation findByValue(String value);

    boolean existsByValue(String otp);
}