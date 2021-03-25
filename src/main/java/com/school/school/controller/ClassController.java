package com.school.school.controller;

import com.school.school.dto.ClassRoomDto;
import com.school.school.dto.ResponseDto;
import com.school.school.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("class")
@SessionAttributes("user")
 public class ClassController {


    @Autowired
    ClassRoomService classRoomService;




    @RequestMapping("/")
    public String addClass(Model model){
         model.addAttribute("rooms",classRoomService.fetchAll().getData());
        return "classRoom_list";
    }

    @GetMapping("/insertPage")
    public String getInsertPage(){
        return "classRoom_form";
    }

    @PostMapping("/addClassRoom")
    @ResponseBody
    public ResponseDto saveClassRoom(@RequestBody ClassRoomDto classRoomDto){
        return classRoomService.saveClassRoom(classRoomDto);
    }

    @PostMapping("/updateClassRoom")
    @ResponseBody
    public ResponseDto updateClassRoom(@RequestBody ClassRoomDto classRoomDto){
        return classRoomService.updateClassRoom(classRoomDto);
    }

    @GetMapping("/deactivateClassRoom")
    @ResponseBody
    public ResponseDto deleteClassRoom(@RequestParam long id){
        return classRoomService.deactivateClassRoom(id);
    }

    @GetMapping("/activateClassRoom")
    @ResponseBody
    public ResponseDto activateClassRoom(@RequestParam long id){
        return classRoomService.activateClassRoom(id);
    }

    @GetMapping("/getAllClasses")
    @ResponseBody
    public ResponseDto findAllClasses(){
        return classRoomService.fetchAll();
    }

    @GetMapping("/getUpdateData")
    public String getClassData(@RequestParam long id, Model model){
        model.addAttribute("room",classRoomService.getClassData(id).getData());
         return "classRoom_form";
    }

    @GetMapping("/mySchedule")
    public String addMyTime(Model model){
         return "memberSchedule";
    }


}
