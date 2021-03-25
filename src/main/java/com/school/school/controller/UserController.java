package com.school.school.controller;

import com.school.school.dto.UserRoleDto;
import com.school.school.service.UserRoleService;
import com.school.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;


    @RequestMapping("/")
    public String addUser(Model model){
        model.addAttribute("user", userService.fetchUser());
        return "user_list";
    }


    @GetMapping("insertPage")
    public String addPage(Model model){
        List<UserRoleDto> userRolesDtos = userRoleService.getActiveUserRoleList();
        model.addAttribute("userRoles",userRolesDtos);
        return "user_form";





    }



























}
