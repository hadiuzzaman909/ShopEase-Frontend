package com.example.shopease.authentication.mapper;

import com.example.shopease.authentication.dto.response.RoleResponse;
import com.example.shopease.authentication.model.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    List<RoleResponse> toRolesResponse(List<Role> all);
}