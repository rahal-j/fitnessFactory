package com.school.school.controller;

import com.school.school.dto.Md5Encryption;
import com.school.school.dto.ResponseDto;
import com.school.school.dto.UserDto;
import com.school.school.entity.User;
import com.school.school.enums.ResponseEnum;
import com.school.school.service.UserRoleService;
import com.school.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("user")
public class LoginController {

    @Autowired
    UserRoleService userRoleService;

    @Autowired
    UserService userService;


    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }



    @GetMapping("/")
    public String index() {
        return "login";
    }


    @RequestMapping("/doLogin")
    public String login(@RequestParam String username, @RequestParam String password, Model model){
        User user = (User) model.getAttribute("user");
//        System.out.println(user.getUserRole().getName());
          user = userService.getUserfromUsernameAndPw(username,password);
        if(user != null){
            model.addAttribute("user",user);
            return "dashboard";
         }
         return "login";
    }


    @RequestMapping("/doLogin-mobile")
    @ResponseBody
    public ResponseDto loginMobile(@RequestParam String username, @RequestParam String password){
        User user =null;
//        System.out.println(user.getUserRole().getName());
   //     user = userService.getUserByUsername(username,password);
        if(user != null){
             return new ResponseDto(ResponseEnum.SUCCESS.getCode(),"Logged in Successfully",user.getId());
        }
        return new ResponseDto(ResponseEnum.FAIL.getCode(),"Logging Failed");

    }
    @RequestMapping("/logout")
    public String logout(Model model,HttpSession httpSession){
        httpSession.removeAttribute("user");
        httpSession.invalidate();
        return "login";
    }

    @RequestMapping("/dashboard")
    public String logout(Model model){

        return "dashboard";
    }

  /*  @PostMapping("/login2")
    public ResponseDto doLogin(@RequestBody UserDto userDto, Model model) {


        User user = userService.getUserByUsername(loginDto.getUsername());
        if(user != null){
            model.addAttribute("user",user);
            return new ResponseDto(ResponseEnum.SUCCESS.getCode(),"Success login");
        }
        return new ResponseDto(ResponseEnum.FAIL.getCode(),"Failed login");
     }*/

}
