package com.school.school.controller;


import com.school.school.dto.ExerciseDto;
import com.school.school.dto.ResponseDto;
import com.school.school.dto.SubscriptionDto;
import com.school.school.service.ExerciseServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("exercise")
@Controller
public class ExerciseController {

    @Autowired
    private ExerciseServise exerciseServise;




    @RequestMapping("/")
    public String addExercise(Model model) {
        model.addAttribute("exercises", exerciseServise.fetchExercise());
        return "exercise_list";
    }


    @GetMapping("/insertPage")
    public String getInsertPage() {
        return "exercise_form";
    }


    @PostMapping("/save")
    @ResponseBody
    public ResponseDto saveExercise(@RequestBody
                                                ExerciseDto exerciseDto) {
        return exerciseServise.addExercise(exerciseDto);
    }

    @GetMapping("/deactivate")
    @ResponseBody
    public ResponseDto activate(@RequestParam int id){return exerciseServise.deactivate(id);}

    @GetMapping("/activate")
    @ResponseBody
    public ResponseDto deactivate(@RequestParam int id){return exerciseServise.activate(id);}

    @GetMapping("getUpdateData")
    public String getExerciseData(@RequestParam int id, Model model){
        model.addAttribute("exercise",exerciseServise.getExerciseData(id).getData());
        return "exercise_form";
    }

    @PostMapping("/update")
    @ResponseBody
    public ResponseDto update(@RequestBody ExerciseDto exerciseDto) {
        return exerciseServise.update(exerciseDto);
    }
















}
