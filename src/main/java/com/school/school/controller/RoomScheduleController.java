package com.school.school.controller;

import com.school.school.dto.ResponseDto;
import com.school.school.dto.RoomScheduleDto;
import com.school.school.service.ClassRoomService;
import com.school.school.service.CourseService;
import com.school.school.service.RoomScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/roomSchedule")
public class RoomScheduleController {




    @Autowired
    RoomScheduleService roomScheduleService;

    @Autowired
    ClassRoomService classRoomService;

    @Autowired
    CourseService courseService;


    @RequestMapping("/")
    public String addRoomSchedule(Model model){
        model.addAttribute("roomSchedules",roomScheduleService.findRecordsFromToday().getData());
        return "roomScheduleList";
    }

    @GetMapping("/insertPage")
    public String getInsertPage(Model model){
        model.addAttribute("courses",courseService.getActiveCourses().getData());
        model.addAttribute("rooms",classRoomService.getActiveClasses().getData());
        return "roomSchedule";
    }

    @PostMapping("/addRoomSchedule")
    @ResponseBody
    public ResponseDto saveCourse(@RequestBody RoomScheduleDto roomScheduleDto){
        return roomScheduleService.saveRoomSchedule(roomScheduleDto);
    }

    @GetMapping("/deactivateRoomSchedule")
    @ResponseBody
    public ResponseDto deactivateSchedule(@RequestParam long id){
        return roomScheduleService.deactivateSchedule(id);
    }

    @GetMapping("/activateRoomSchedule")
    @ResponseBody
    public ResponseDto activateSchedule(@RequestParam long id){
        return roomScheduleService.activateSchedule(id);
    }


    @GetMapping("/getUpdateData")
    public String getScheduleData(@RequestParam long id, Model model){
        model.addAttribute("rooms",classRoomService.fetchAll().getData());
        model.addAttribute("courses",courseService.fetchAll().getData());
        model.addAttribute("roomSchedule",roomScheduleService.getRoomScheduleData(id).get("roomSchedule"));
        model.addAttribute("course",roomScheduleService.getRoomScheduleData(id).get("course"));
        model.addAttribute("room",roomScheduleService.getRoomScheduleData(id).get("room"));
        return "roomSchedule";
    }

}
