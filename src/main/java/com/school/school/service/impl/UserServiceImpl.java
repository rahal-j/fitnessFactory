package com.school.school.service.impl;

import com.school.school.dto.ResponseDto;
import com.school.school.dto.UserDto;
import com.school.school.dtoToEntityMapper.UserDtoToEntityMapper;
import com.school.school.entity.Member;
import com.school.school.entity.User;
import com.school.school.entity.UserRole;
import com.school.school.entityToDtoMapper.UserEntityToDtoMapper;
import com.school.school.enums.ResponseEnum;
import com.school.school.enums.TransactionStatus;
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




    @Override
    public ResponseDto deactivate(int id) {
        ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode(), ResponseEnum.FAIL.getMsg());
        User user = userDao.getOne(id);
        if (user != null) {
            user.setStatus(TransactionStatus.DEACTIVE.getCode());
            userDao.save(user);
            return new ResponseDto(ResponseEnum.SUCCESS.getCode(), "Member deactivated successfully");
        }
        return responseDto;

    }



    @Override
    public ResponseDto activate(int id){
        ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode(),ResponseEnum.FAIL.getMsg());
       User user = userDao.getOne(id);
        if (user!= null){
            user.setStatus(TransactionStatus.ACTIVE.getCode());
            userDao.save(user);
            return new ResponseDto(ResponseEnum.SUCCESS.getCode(),"Member Activated Successfully");

        }
        return responseDto;
    }



    public ResponseDto getUserData(int id){
        User user = new User();
        user = userDao.getOne(id);

        return new ResponseDto(UserEntityToDtoMapper.getUserDto(new UserDto(),user));


    }







    }





  /*  public ResponseDto getUserByUserName(String userName){
        User user = null;
        ResponseDto responseDto = new ResponseDto();
        UserDto userDto = new UserDto();

        user = userDao.findByUserName(userName);
        userDto = UserEntityToDtoMapper.getUserDto(user.setUserName());










}*/
