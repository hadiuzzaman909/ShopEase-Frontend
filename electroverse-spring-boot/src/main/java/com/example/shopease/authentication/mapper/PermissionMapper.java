package com.example.shopease.authentication.mapper;

import com.example.shopease.authentication.dto.response.PermissionResponse;
import com.example.shopease.authentication.model.Permission;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    List<PermissionResponse> toAuthPermissions(List<Permission> permissions);
}