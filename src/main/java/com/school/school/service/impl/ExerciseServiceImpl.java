package com.school.school.service.impl;


import com.school.school.dto.ExerciseDto;
import com.school.school.dto.ResponseDto;
import com.school.school.dto.SubscriptionDto;
import com.school.school.dtoToEntityMapper.ExerciseDtoToEntityMapper;
import com.school.school.dtoToEntityMapper.SubscriptionDtoToEntityMapper;
import com.school.school.entity.Exercise;
import com.school.school.entity.Subscription;
import com.school.school.entityToDtoMapper.ExerciseEntityToDtoMapper;
import com.school.school.enums.ResponseEnum;
import com.school.school.enums.TransactionStatus;
import com.school.school.repository.ExerciseDao;
import com.school.school.service.ExerciseServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExerciseServiceImpl  implements ExerciseServise {


    @Autowired
  private ExerciseDao exerciseDao;


    @Override
    public ResponseDto addExercise(ExerciseDto exerciseDto){
  ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode(), "Transaction Fail");
  try{
      Exercise exercise = ExerciseDtoToEntityMapper.getExerciseEntity(exerciseDto,new Exercise());
      exerciseDao.save(exercise);
      responseDto.setCode(ResponseEnum.SUCCESS.getCode());
      responseDto.setMessage("Exercise saved Successful");
      return responseDto;



  }catch (Exception e){
      return responseDto;


  }




    }

    @Override
    public List<Exercise> fetchExercise() {
        return exerciseDao.findAll();
    }


    @Override
    public ResponseDto deactivate(int id){
        ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode(),ResponseEnum.FAIL.getMsg());
        Exercise exercise = exerciseDao.getOne(id);
        if(exercise != null){
            exercise.setStatus(TransactionStatus.DEACTIVE.getCode());
            exerciseDao.save(exercise);
            return new ResponseDto(ResponseEnum.SUCCESS.getCode(),"Exercise Deactivate Successfully");
        }
        return responseDto;

    }


    @Override
    public ResponseDto activate(int id){
        ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode(),ResponseEnum.FAIL.getMsg());
        Exercise exercise = exerciseDao.getOne(id);
        if (exercise != null){
            exercise.setStatus(TransactionStatus.ACTIVE.getCode());
            exerciseDao.save(exercise);
            return new ResponseDto(ResponseEnum.SUCCESS.getCode(),"Exercise Activate Successfully");
            }
            return responseDto;

    }

    @Override
    public ResponseDto getExerciseData(int id){
        return new ResponseDto(ExerciseEntityToDtoMapper.getExerciseDto(new ExerciseDto(),exerciseDao.getOne(id)));
        }


    @Override
    public ResponseDto update(ExerciseDto exerciseDto){
        ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode(),ResponseEnum.FAIL.getMsg());
       Exercise exercise  = exerciseDao.findByName(exerciseDto.getName());
        if(exercise != null){
            exerciseDao.save(ExerciseDtoToEntityMapper.getExerciseEntity(exerciseDto,exercise));
            return new ResponseDto(ResponseEnum.SUCCESS.getCode(),"Exercise updated successfully");

        }
        return responseDto;
    }



    @Override
    public List<ExerciseDto> getActiveExerciseList(){
        List<ExerciseDto> exerciseDtos = new ArrayList<>();
        List<Exercise> exercises = exerciseDao.findAllByStatus("ACTIVE");
        for (Exercise exercise : exercises){
            ExerciseDto exerciseDto = ExerciseEntityToDtoMapper.getExerciseDto(new ExerciseDto(), exercise);
            exerciseDtos.add(exerciseDto);


        }
        return exerciseDtos;

    }












}
