package com.school.school.service.impl;

import com.school.school.dto.ResponseDto;
import com.school.school.dto.ScheduleDto;
import com.school.school.dtoToEntityMapper.ScheduleDtoToEntityMapper;
import com.school.school.entity.Exercise;
import com.school.school.entity.Member;
import com.school.school.entity.Schedule;
import com.school.school.entityToDtoMapper.ScheduleEntityToDtoMapper;
import com.school.school.enums.ResponseEnum;
import com.school.school.repository.ExerciseDao;
import com.school.school.repository.MemberDao;
import com.school.school.repository.ScheduleDao;
import com.school.school.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {


    @Autowired
    private ScheduleDao scheduleDao;


    @Autowired
    private ExerciseDao exerciseDao;

    @Autowired
    private MemberDao memberDao;



    @Override
    public ResponseDto addSchedule(ScheduleDto scheduleDto){

        ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode() , "Transaction Fail");

        try{
            Exercise exercise = exerciseDao.getOne(scheduleDto.getExerciseId());

            Schedule schedule = ScheduleDtoToEntityMapper.getScheduleEntity(scheduleDto, new Schedule(),exercise, new Member());
            scheduleDao.save(schedule);
            responseDto.setCode(ResponseEnum.SUCCESS.getCode());
            responseDto.setMessage("Schedule Save Successful");
            return responseDto;
        }catch (Exception e){

            return responseDto;

        }
    }






    @Override
    public List<Schedule> fetchSchedule(){return scheduleDao.findAll();
    }



   @Override
    public ResponseDto getScheduleDto(String nic){
       Member member = null;
       ResponseDto responseDto = new ResponseDto();
       ScheduleDto scheduleDto = new ScheduleDto();
       member = memberDao.findByNic(nic);
       scheduleDto = ScheduleEntityToDtoMapper.getScheduleDto(member);
       if (member != null){
           responseDto.setCode(ResponseEnum.SUCCESS.getCode());
           responseDto.setMessage("Please Proceed");
           responseDto.setData(scheduleDto);
       }else{
           responseDto.setCode(ResponseEnum.FAIL.getCode());
           responseDto.setMessage("Please Do The Registration First");

       }

       return responseDto;
   }







   @Override
   public ResponseDto saveScheduleArray(ScheduleDto scheduleDto) {
       ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode(), "Transaction Fail");

       try {
           for (int i = 0; i < scheduleDto.getExercises().size(); i++) {

               Schedule schedule = new Schedule();
               schedule.setSets(Integer.parseInt(scheduleDto.getSetsLIst().get(i)));
               schedule.setReps(Integer.parseInt(scheduleDto.getRepsList().get(i)));
               schedule.setScheduleNo(Integer.parseInt(scheduleDto.getScheduleNos().get(i)));
               Exercise exercise = exerciseDao.getOne(Integer.parseInt((scheduleDto.getExercises().get(i))));

               scheduleDao.save(schedule);
               responseDto.setCode(ResponseEnum.SUCCESS.getCode());
               responseDto.setMessage("Schedule Added");

           }
       } catch (Exception e) {
           return responseDto;
       }

       return responseDto;
   }

























}
