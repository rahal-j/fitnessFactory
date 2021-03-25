package com.school.school.repository;

import com.school.school.entity.User;
import com.school.school.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleDao extends JpaRepository<UserRole,Integer> {


    List<UserRole> findAllByStatus(String status);
    UserRole findByName(String code);
}
