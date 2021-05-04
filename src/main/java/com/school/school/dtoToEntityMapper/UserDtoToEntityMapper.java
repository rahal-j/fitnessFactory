package com.school.school.dtoToEntityMapper;

import com.school.school.dto.UserDto;
import com.school.school.entity.User;
import com.school.school.entity.UserRole;
import com.school.school.enums.TransactionStatus;

public class UserDtoToEntityMapper {

    public static User getUserEntity(UserDto userDto, User user, UserRole userRole){

        user.setId(user.getId() !=null? user.getId() : userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setAddress(userDto.getAddress());
        user.setStatus(TransactionStatus.ACTIVE.getCode());
        user.setDob(userDto.getDob());
        user.setGender(userDto.getGender());
        user.setContactNo(userDto.getContactNo());
        user.setNic(userDto.getNic());
        user.setTitle(userDto.getTitle());
        user.setUserName(userDto.getUserName());
        user.setPassWord(userDto.getPassword());
        user.setUserRole(userRole);

        return user;








    }






}
