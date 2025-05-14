package com.example.shopease.authentication.repository;

import com.example.shopease.authentication.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission,Long> {
    boolean existsByName(String name);
}