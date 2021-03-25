package com.school.school.controller;


import com.school.school.dto.ClassRoomDto;
import com.school.school.dto.ResponseDto;
import com.school.school.dto.SubjectDto;
import com.school.school.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/subject")
@SessionAttributes("user")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @RequestMapping("/")
    public String addSubject(Model model) {
        model.addAttribute("subjects", subjectService.fetchAll().getData());
        return "subject_list";
    }

    @GetMapping("/insertPage")
    public String getInsertPage() {
        return "subject_form";
    }

    @PostMapping("/addSubject")
    @ResponseBody
    public ResponseDto saveSubject(@RequestBody SubjectDto subjectDto) {
        return subjectService.saveSubject(subjectDto);
    }

    @PostMapping("/updateSubject")
    @ResponseBody
    public ResponseDto updateSubject(@RequestBody SubjectDto subjectDto) {
        return subjectService.updateSubject(subjectDto);
    }

    @GetMapping("/deleteSubject")
    @ResponseBody
    public ResponseDto deleteSubject(@RequestParam long id) {
        return subjectService.deleteSubject(id);
    }

    @GetMapping("/getAllClasses")
    @ResponseBody
    public ResponseDto findAllSubjects() {
        return subjectService.fetchAll();
    }


    @GetMapping("/deactivateSubject")
    @ResponseBody
    public ResponseDto deactivateSubject(@RequestParam long id) {
        return subjectService.deactivateSubject(id);
    }

    @GetMapping("/activateSubject")
    @ResponseBody
    public ResponseDto activateSubject(@RequestParam long id) {
        return subjectService.activateSubject(id);
    }


    @GetMapping("/getUpdateData")
    public String getClassData(@RequestParam long id, Model model) {
        model.addAttribute("subject", subjectService.getSubjectData(id).getData());
        return "subject_form";
    }

}
