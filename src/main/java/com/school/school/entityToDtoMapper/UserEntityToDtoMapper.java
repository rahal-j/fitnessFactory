package com.school.school.entityToDtoMapper;

import com.school.school.dto.UserDto;
import com.school.school.entity.User;

public class UserEntityToDtoMapper {

    public static UserDto getUserDto(UserDto userDto, User user){
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setGender(user.getGender());
        userDto.setEmail(user.getEmail());
        userDto.setStatus(user.getStatus());
        userDto.setDob(user.getDob());
        userDto.setContactNo(user.getContactNumber());
        userDto.setNic(user.getNic());
        userDto.setUsername(user.getUserName());
        userDto.setPassword(user.getPassWord());
        userDto.setAddress(user.getAddress());
        userDto.setTitle(user.getTitle());

        return userDto;

    }





}
