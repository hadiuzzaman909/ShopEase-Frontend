package com.example.shopease.authentication.repository;

import com.example.shopease.authentication.model.RefreshToken;
import com.example.shopease.authentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<RefreshToken,Long> {
    RefreshToken findByValue(String refreshToken);

    RefreshToken findByUser(User user);
}