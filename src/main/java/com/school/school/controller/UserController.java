package com.school.school.controller;

import com.school.school.dto.ResponseDto;
import com.school.school.dto.UserDto;
import com.school.school.dto.UserRoleDto;
import com.school.school.service.UserRoleService;
import com.school.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("users", userService.fetchUser());
        return "user_list";
    }


    @GetMapping("/insertPage")
    public String addPage(Model model){
        List<UserRoleDto> userRolesDtos = userRoleService.getActiveUserRoleList();
        model.addAttribute("userRoles",userRolesDtos);
        return "user_form";

    }

    @PostMapping("/save")
    @ResponseBody
    public ResponseDto saveMember(@RequestBody UserDto userDto){
        return userService.addUser(userDto);
    }


    @GetMapping("/activate")
    @ResponseBody
    public ResponseDto activate(@RequestParam int id) {
        return userService.activate(id);
    }

    @GetMapping("/deactivate")
    @ResponseBody
    public ResponseDto deactivate(@RequestParam int id) {
        return userService.deactivate(id);
    }



    @GetMapping("/getUpdateData")
    public String getMemberData(@RequestParam int id, Model model) {
        model.addAttribute("user",userService.getUserData(id).getData());
        return "user_form";
    }





























}
