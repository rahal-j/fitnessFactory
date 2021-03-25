package com.school.school.service.impl;

import com.school.school.dto.ResponseDto;
import com.school.school.dto.UserDto;
import com.school.school.dtoToEntityMapper.UserDtoToEntityMapper;
import com.school.school.entity.User;
import com.school.school.entity.UserRole;
import com.school.school.enums.ResponseEnum;
import com.school.school.repository.UserDao;
import com.school.school.repository.UserRoleDao;
import com.school.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public ResponseDto addUser(UserDto userDto){

        ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode(),"Transaction failed");
        try{

            UserRole userRole = userRoleDao.getOne(userDto.getUserRole());
            User user = UserDtoToEntityMapper.getUserEntity(userDto,new User(),userRole);
            userDao.save(user);
            responseDto.setCode(ResponseEnum.SUCCESS.getCode());
            responseDto.setMessage("User Save successful");

            return responseDto;

        }catch(Exception e){
            return responseDto;
        }

    }

    @Override
    public List<User> fetchUser(){return userDao.findAll();}











}
