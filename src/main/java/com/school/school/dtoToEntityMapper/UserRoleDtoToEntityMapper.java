package com.school.school.dtoToEntityMapper;

import com.school.school.dto.UserRoleDto;
import com.school.school.entity.UserRole;

public class UserRoleDtoToEntityMapper {

    public static UserRole getUserRoleEntity(UserRoleDto userRoleDto, UserRole userRole){

        userRole.setId(userRole.getId() != null? userRole.getId() : userRoleDto.getId());
        userRole.setName(userRoleDto.getName());
        userRole.setStatus(userRoleDto.getStatus());
        return userRole;



    }





}
