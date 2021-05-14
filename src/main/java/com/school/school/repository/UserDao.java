package com.school.school.repository;

import com.school.school.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {


    User findByUserName (String userName);

    User findByUserNameAndPassWord(String username, String pass);




}
