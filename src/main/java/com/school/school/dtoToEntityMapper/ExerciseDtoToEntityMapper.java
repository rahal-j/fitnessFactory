package com.school.school.dtoToEntityMapper;

import com.school.school.dto.ExerciseDto;
import com.school.school.entity.Exercise;
import com.school.school.enums.TransactionStatus;

public class ExerciseDtoToEntityMapper {

    public static Exercise getExerciseEntity(ExerciseDto exerciseDto, Exercise exercise){

        exercise.setId(exercise.getId() != null? exercise.getId(): exerciseDto.getId() );
        exercise.setName(exerciseDto.getName());
        exercise.setStatus(exerciseDto.getStatus());
        return exercise;
        }
    }
