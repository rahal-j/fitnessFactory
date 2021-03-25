package com.school.school.controller;


import com.school.school.dto.ResponseDto;
import com.school.school.dto.UserRoleDto;
import com.school.school.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("userRole")
@Controller
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping("/")
    public String addPage(Model model){
        model.addAttribute("userRole", userRoleService.fetchUserRole());
        return "userRole_list";
    }

    @GetMapping("/insertPage")
    public String getInsertPage(){
        return "userRole_form";
    }

    @PostMapping("/save")
    @ResponseBody
    public ResponseDto saveUserRole(@RequestBody UserRoleDto userRoleDto){
        return userRoleService.addUserRole(userRoleDto);

    }










}
