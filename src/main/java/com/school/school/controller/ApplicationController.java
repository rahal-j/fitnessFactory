/*
package com.school.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

*/
/**
 * @author Shalika Jayathilaka
 *//*


@Controller
@SessionAttributes("user")
 public class ApplicationController {

    @RequestMapping("/home")
    public String Hello(){
        return "dashboard";
    }

    @RequestMapping("/welcome")
    public String welcome(){
        return "welcomePage";
    }

    @RequestMapping("/login")
     public String login(Model model){
        User user = (User) model.getAttribute("user");
        model.addAttribute("user",user);
        model.addAttribute("ttest","amanda");

        return "login";
    }



//    @PostMapping("/save-user")
//    public String registerUser(BindingResult bindingResult, HttpServletRequest request){
//        // user Service to save the user
//        request.setAttribute("mode","MODE_HOME");
//        return "welcomePage";
//    }
}
*/
