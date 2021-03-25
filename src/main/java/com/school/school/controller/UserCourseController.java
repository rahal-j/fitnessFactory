/*
package com.school.school.controller;

import com.school.school.dto.ResponseDto;
import com.school.school.dto.UserCourseDto;
import com.school.school.entity.User;
import com.school.school.service.CourseService;
import com.school.school.service.UserCourseService;
import com.school.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/userCourse")
@SessionAttributes("user")
public class UserCourseController {

    @Autowired
    UserCourseService userCourseService;

    @Autowired
    UserService userService;

    @Autowired
    CourseService courseService;

    @RequestMapping("/")
    public String addUserRole(Model model) {
        model.addAttribute("userCourse", userCourseService.fetchAll().getData());
        return "userCourseList";
    }

    @GetMapping("/insertPage")
    public String getInsertPage(Model model) {

        model.addAttribute("courses", courseService.fetchAll().getData());
        return "userCourseForm";
    }

    @PostMapping("/addUserCourse")
    @ResponseBody
    public ResponseDto saveUserCourse(@RequestBody UserCourseDto userCourseDto) {
        return userCourseService.saveUserCourse(userCourseDto);
    }

    @GetMapping("/getUpdateData")
    public String getUserCourseData(@RequestParam long id, Model model) {
        model.addAttribute("courses", courseService.fetchAll().getData());
        model.addAttribute("userCourse", userCourseService.getCourseFromNic(id).getData());
        return "userCourseForm";
    }


    @GetMapping("/getMemberCourses")
    @ResponseBody
    public ResponseDto getMemberCourseData(Model model) {
        User user = (User) model.getAttribute("user");
        return userCourseService.getClassTimeForMember(user.getId());

    }

    @GetMapping("/getMemberCourses-mobile")
    @ResponseBody
    public ResponseDto getMemberCourseDataMobile(@RequestParam String userId) {
         return  userCourseService.getClassTimeForMember(Long.parseLong(userId));

    }

    @RequestMapping("/loadMemberForm")
    public String loadMemberForm(Model model) {
         return "memberSchedule";
    }

}
*/
