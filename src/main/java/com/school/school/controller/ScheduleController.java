package com.school.school.controller;

import com.school.school.dto.ExerciseDto;
import com.school.school.dto.ResponseDto;
import com.school.school.dto.ScheduleDto;
import com.school.school.dto.ScheduleExerciseDto;
import com.school.school.service.ExerciseServise;
import com.school.school.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("schedule")
@Controller
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private ExerciseServise exerciseServise;

    @RequestMapping("/")
    public String addSchedule(Model model){

        model.addAttribute("schedule",scheduleService.fetchSchedule());
        return "schedule_list";
    }

    @GetMapping("/insertPage")
    public String addPage(Model model){
        List<ExerciseDto> exerciseDtos = exerciseServise.getActiveExerciseList();
        model.addAttribute("exercises",exerciseDtos);
        return "schedule";

    }

    @PostMapping("/save")
    @ResponseBody
    public ResponseDto saveSchedule(@RequestBody ScheduleExerciseDto scheduleExerciseDto){
        return scheduleService.saveScheduleArray(scheduleExerciseDto);



    }

    @GetMapping("/searchMember")
    @ResponseBody
    public ResponseDto getScheduleDto(@RequestParam String nic){
        return scheduleService.getScheduleDto(nic);
    }


    @GetMapping("/exerciseList")
    @ResponseBody
    public ResponseDto getAllExercise(){
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(exerciseServise.getActiveExerciseList());
        return responseDto;
    }








}
