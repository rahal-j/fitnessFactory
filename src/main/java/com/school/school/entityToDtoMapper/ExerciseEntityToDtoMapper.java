package com.school.school.entityToDtoMapper;

import com.school.school.dto.ExerciseDto;
import com.school.school.entity.Exercise;

public class ExerciseEntityToDtoMapper {
    public static ExerciseDto getExerciseDto(ExerciseDto exerciseDto, Exercise exercise){
        exerciseDto.setId(exercise.getId());
        exerciseDto.setName(exercise.getName());
        exerciseDto.setStatus(exercise.getStatus());


        return exerciseDto;



    }
















}
