package com.school.school.service.impl;

import com.school.school.dto.ResponseDto;
import com.school.school.dto.ScheduleDto;
import com.school.school.dto.ScheduleExerciseDto;
import com.school.school.dtoToEntityMapper.ScheduleDtoToEntityMapper;
import com.school.school.entity.Exercise;
import com.school.school.entity.Member;
import com.school.school.entity.Schedule;
import com.school.school.entityToDtoMapper.ScheduleEntityToDtoMapper;
import com.school.school.enums.ResponseEnum;
import com.school.school.enums.TransactionStatus;
import com.school.school.repository.ExerciseDao;
import com.school.school.repository.MemberDao;
import com.school.school.repository.ScheduleDao;
import com.school.school.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
    public List<Schedule> fetchSchedule(){
        return scheduleDao.findGroupByShedules();
    }


    @Override
    public List<Schedule> fetchSchedulefromMember(String nic){


        Member member = memberDao.findByNic(nic);

        List<Schedule> schedules = scheduleDao.findByMemberIdAndStatus(member,TransactionStatus.ACTIVE.getCode());

        return schedules;
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
   public ResponseDto saveScheduleArray(ScheduleExerciseDto scheduleExerciseDto){
        ResponseDto responseDto =new ResponseDto(ResponseEnum.FAIL.getCode(),"Transaction Fail");
        List<Schedule> schedules = new ArrayList<>();
        try{

            int min = 100;
            int max = 10000;
            String sheduleId = "SCH_";
            int b = (int)(Math.random()*(max-min+1)+min);
            sheduleId = sheduleId+b;

            Member member = new Member();
            member = memberDao.findByNic(scheduleExerciseDto.getMemberId());




                schedules = scheduleDao.findByMemberIdAndStatus(member,TransactionStatus.ACTIVE.getCode());

                if (schedules.size() == 0 || schedules.isEmpty()){

                    for(int i=0; i< scheduleExerciseDto.getExercises().size(); i++) {
                        Schedule schedule = new Schedule();
                        Exercise exercise = exerciseDao.getOne(Integer.valueOf(scheduleExerciseDto.getExercises().get(i)));
                        schedule.setExerciseId(exercise);
                        schedule.setReps(Integer.parseInt(scheduleExerciseDto.getRepsList().get(i)));
                        schedule.setSets(Integer.parseInt(scheduleExerciseDto.getSetsList().get(i)));
                        schedule.setScheduleId(sheduleId);

                        schedule.setMemberId(member);
                        schedule.setName(scheduleExerciseDto.getScheduleName());
                        schedule.setDate(new Date());
                        schedule.setStatus(TransactionStatus.ACTIVE.getCode());
                        scheduleDao.save(schedule);
                    }
                }else {

                    for (Schedule schedule1 : schedules){

                        schedule1.setStatus(TransactionStatus.DEACTIVE.getCode());
                        scheduleDao.save(schedule1);

                    }
                    for(int i=0; i< scheduleExerciseDto.getExercises().size(); i++) {
                        Schedule schedule = new Schedule();
                        Exercise exercise = exerciseDao.getOne(Integer.valueOf(scheduleExerciseDto.getExercises().get(i)));
                        schedule.setExerciseId(exercise);
                        schedule.setReps(Integer.parseInt(scheduleExerciseDto.getRepsList().get(i)));
                        schedule.setSets(Integer.parseInt(scheduleExerciseDto.getSetsList().get(i)));
                        schedule.setScheduleId(sheduleId);

                        schedule.setMemberId(member);
                        schedule.setName(scheduleExerciseDto.getScheduleName());
                        schedule.setDate(new Date());
                        schedule.setStatus(TransactionStatus.ACTIVE.getCode());
                        scheduleDao.save(schedule);
                    }

                }

                responseDto.setCode(ResponseEnum.SUCCESS.getCode());
                responseDto.setMessage("Your Schedule is :"+sheduleId);





        }catch (Exception e){
            return responseDto;
        }
        return responseDto;


   }





























}
