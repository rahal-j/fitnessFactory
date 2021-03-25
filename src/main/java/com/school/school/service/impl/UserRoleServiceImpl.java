package com.school.school.service.impl;


import com.school.school.dto.ResponseDto;
import com.school.school.dto.UserRoleDto;
import com.school.school.dtoToEntityMapper.UserRoleDtoToEntityMapper;
import com.school.school.entity.User;
import com.school.school.entity.UserRole;
import com.school.school.entityToDtoMapper.UserRoleEntityToDtoMapper;
import com.school.school.enums.ResponseEnum;
import com.school.school.repository.UserRoleDao;
import com.school.school.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {


    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public ResponseDto addUserRole(UserRoleDto userRoleDto){

        ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode(), "Transaction Fail");

        try{
            UserRole userRole = UserRoleDtoToEntityMapper.getUserRoleEntity(userRoleDto, new UserRole());
            userRoleDao.save(userRole);
            responseDto.setCode(ResponseEnum.SUCCESS.getCode());
            responseDto.setMessage("User Role save Successful");
            return responseDto;
        }catch (Exception e){
            return responseDto;
        }



    }

    @Override
    public List<UserRole> fetchUserRole(){

        return userRoleDao.findAll();
    }



    @Override
    public List<UserRoleDto> getActiveUserRoleList(){
        List<UserRoleDto> userRoleDtos = new ArrayList<>();
        List<UserRole> userRoles = userRoleDao.findAllByStatus("ACTIVE");
        for (UserRole userRole : userRoles){
            UserRoleDto userRoleDto = UserRoleEntityToDtoMapper.getUserRoleDto(new UserRoleDto(),userRole);
            userRoleDtos.add(userRoleDto);
        }
        return userRoleDtos;

    }









}
