package com.school.school.controller;


import com.school.school.dto.CourseDto;
import com.school.school.dto.CourseSubjectDto;
import com.school.school.dto.ResponseDto;
import com.school.school.service.CourseService;
import com.school.school.service.CourseSubjectService;
import com.school.school.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courseSubject")
public class CourseSubjectController {


    @Autowired
    CourseService courseService;

    @Autowired
    SubjectService subjectService;

    @Autowired
    CourseSubjectService courseSubjectService;

    @RequestMapping("/")
    public String addCourse(Model model) {
        model.addAttribute("courses", courseService.fetchAll().getData());
        return "course_subject_list";
    }

    @GetMapping("/insertPage")
    public String getInsertPage(Model model) {
        model.addAttribute("subjects", subjectService.getActiveSubjectList());
        model.addAttribute("courses", courseService.fetchAll().getData());
        return "course_subject_form";
    }

    @PostMapping("/addCourseSubject")
    @ResponseBody
    public ResponseDto saveCourseSubject(@RequestBody CourseSubjectDto courseSubjectDto) {
        return courseSubjectService.saveCourseSubject(courseSubjectDto);
    }

    @GetMapping("/getUpdateData")
    public String getCourseSubject(@RequestParam long id, Model model) {
        model.addAttribute("courses", courseService.fetchAll().getData());
        model.addAttribute("course", courseSubjectService.getCourseFromId(id).getData());
        model.addAttribute("action", "update");
        model.addAttribute("subjects", subjectService.getActiveSubjectList());

        return "course_subject_form";
    }

    @PostMapping("/getRelevantSubjects")
    public ResponseDto getRelevantSubjects(@RequestBody String  id){
        return courseSubjectService.getCourseSubject(Long.parseLong(id));
    }


    @GetMapping("/getSubjectsOfCourse")
    public ResponseDto getUserCourseData(@RequestParam String courseId, Model model){
      return   courseSubjectService.getSubjectListFromCourse(Long.parseLong(courseId));
    }

}
