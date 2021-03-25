/*
package com.school.school.dtoToEntityMapper;

import com.school.school.dto.UserDto;
import com.school.school.entity.User;
import com.school.school.enums.TransactionStatus;

import java.util.Date;

public class DtoToEntityUser {


    public static User getUser(User user, UserDto userDto,UserRole userRole){
        user.setId((userDto.getId()!= null && !userDto.getId().isEmpty() )? Long.valueOf(userDto.getId()) : null);
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setGender(Integer.valueOf(userDto.getGender()));
        user.setContactNo(userDto.getContactNo());
        user.setEmail(userDto.getEmail());
        user.setDateCreated(new Date());
        user.setDob(userDto.getDob());
        user.setNic(userDto.getNic());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setUserRole(userRole);
        user.setStatus(TransactionStatus.getEnum(userDto.getStatus()).getCode());
        return user;
    }



}
*/
