package com.school.school.entityToDtoMapper;

import com.school.school.dto.UserRoleDto;
import com.school.school.entity.UserRole;

public class UserRoleEntityToDtoMapper {

    public static UserRoleDto getUserRoleDto(UserRoleDto userRoleDto, UserRole userRole){

        userRoleDto.setId(userRole.getId());
        userRoleDto.setName(userRole.getName());
        userRoleDto.setStatus(userRole.getStatus());
        return userRoleDto;
    }






}
