package com.school.school.service;

import com.school.school.dto.ResponseDto;
import com.school.school.dto.UserRoleDto;
import com.school.school.entity.UserRole;

import java.util.List;

public interface UserRoleService {
    ResponseDto addUserRole(UserRoleDto userRoleDto);

    List<UserRole> fetchUserRole();

    List<UserRoleDto> getActiveUserRoleList();
}
