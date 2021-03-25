package com.school.school.controller;

import com.school.school.dto.CourseDto;
import com.school.school.dto.ResponseDto;
import com.school.school.dto.SubjectDto;
import com.school.school.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/course")
public class CourseController {


    @Autowired
    CourseService courseService;


    @RequestMapping("/")
    public String addCourse(Model model){
        model.addAttribute("courses",courseService.fetchAll().getData());
        return "course_list";
    }

    @GetMapping("/insertPage")
    public String getInsertPage(){
        return "course_form";
    }

    @PostMapping("/addCourse")
    @ResponseBody
    public ResponseDto saveCourse(@RequestBody CourseDto courseDto){
        return courseService.saveCourse(courseDto);
    }

    @PostMapping("/updateCourse")
    @ResponseBody
    public ResponseDto updateCourse(@RequestBody CourseDto courseDto){
        return courseService.updateCourse(courseDto);
    }

    @GetMapping("/deleteCourse")
    @ResponseBody
    public ResponseDto deleteCourse(@RequestParam long id){
        return courseService.deleteCourse(id);
    }

    @GetMapping("/getAllClasses")
    @ResponseBody
    public ResponseDto findAllCourses(){
        return courseService.fetchAll();
    }


    @GetMapping("/deactivateCourse")
    @ResponseBody
    public ResponseDto deactivateCourse(@RequestParam long id){
        return courseService.deactivateCourse(id);
    }

    @GetMapping("/activateCourse")
    @ResponseBody
    public ResponseDto activateCourse(@RequestParam long id){
        return courseService.activateCourse(id);
    }


    @GetMapping("/getUpdateData")
    public String getClassData(@RequestParam long id, Model model){
        model.addAttribute("course",courseService.getCourseData(id).getData());
        return "course_form";
    }
}
