package com.school.school.service;

import com.school.school.dto.ResponseDto;
import com.school.school.dto.UserDto;
import com.school.school.entity.User;

import java.util.List;

public interface UserService {
    ResponseDto addUser(UserDto userDto);

    List<User> fetchUser();



    ResponseDto deactivate(int id);

    User getUserfromUsernameAndPw(String username, String password);

    ResponseDto activate(int id);

    ResponseDto getUserData(int id);
}
