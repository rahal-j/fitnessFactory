package com.school.school.service.impl;

import com.school.school.dto.ClassRoomDto;
import com.school.school.dto.CourseDto;
import com.school.school.dto.ResponseDto;
import com.school.school.dto.RoomScheduleDto;
import com.school.school.dtoToEntityMapper.DtoToEntityRoomSchedule;
import com.school.school.entity.Course;
import com.school.school.entity.Room;
import com.school.school.entity.RoomCourseSchedule;
import com.school.school.entityToDtoMapper.EntityToDtoClass;
import com.school.school.entityToDtoMapper.EntityToDtoCourse;
import com.school.school.entityToDtoMapper.EntityToDtoRoomCourse;
import com.school.school.enums.ResponseEnum;
import com.school.school.enums.TransactionStatus;
import com.school.school.repository.RoomScheduleRepository;
import com.school.school.service.ClassRoomService;
import com.school.school.service.CourseService;
import com.school.school.service.RoomScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class RoomScheduleServiceImpl implements RoomScheduleService {


    @Autowired
    RoomScheduleRepository roomScheduleRepository;

    @Autowired
    CourseService courseService;

    @Autowired
    ClassRoomService classRoomService;

    @Transactional
    @Override
    public ResponseDto fetchAll() {
        return new ResponseDto(roomScheduleRepository.findAll());
    }

    @Transactional
    @Modifying
    @Override
    public ResponseDto saveRoomSchedule(RoomScheduleDto roomScheduleDto) {
         Room room = classRoomService.getRoom(Long.parseLong(roomScheduleDto.getRoom()));

        List<RoomCourseSchedule> roomCourseSchedules = roomScheduleRepository.findRoomSchedulesByStartAndEndDatesAndRoomId(room.getId(),getStartOfTheDate(roomScheduleDto.getStartTime()),
                getEndOfTheDate(roomScheduleDto.getEndTime()));
        Timestamp startTime = getTimestampFromString(roomScheduleDto.getStartTime());
        Timestamp endTime = getTimestampFromString(roomScheduleDto.getEndTime());
        Course course = courseService.getCourse(roomScheduleDto.getCourse());
        //update class
        RoomCourseSchedule roomCourseSchedule = DtoToEntityRoomSchedule.getRoomSchedule(new RoomCourseSchedule(),roomScheduleDto,course,
                startTime,endTime ,room);
        boolean isClassCreatable = true;

        if(roomCourseSchedule.getId() != null){
            roomScheduleRepository.delete(roomCourseSchedule);
        }

        if(roomCourseSchedules.isEmpty()){
            roomScheduleRepository.save(roomCourseSchedule);
            return new ResponseDto(ResponseEnum.SUCCESS.getCode(),"Room has been Successfully Booked !");


        }else{
            for(RoomCourseSchedule roomSchedule : roomCourseSchedules){


                if(startTime.before(roomSchedule.getStartTime()) && endTime.after(roomSchedule.getStartTime())){
                    isClassCreatable = false;
                }else if(startTime.before(roomSchedule.getEndTime()) && endTime.after(roomSchedule.getEndTime())){
                    isClassCreatable = false;

                }else if(startTime.after(roomSchedule.getStartTime()) && endTime.before(roomSchedule.getEndTime())){
                    isClassCreatable = false;

                }else if(startTime.before(roomSchedule.getStartTime()) && endTime.after(roomSchedule.getEndTime())){
                    isClassCreatable = false;

                }else if(startTime.equals(roomSchedule.getStartTime()) && endTime.equals(roomSchedule.getEndTime())){
                    isClassCreatable = false;

                }


            }

            if(isClassCreatable){
                roomScheduleRepository.save(roomCourseSchedule);
                return new ResponseDto(ResponseEnum.SUCCESS.getCode(),"Room has been Successfully Booked !");
            }
        }


            return new ResponseDto(ResponseEnum.FAIL.getCode(),"Room Has Already been booked !");
    }

    private Timestamp getTimestampFromString(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date1 = null;
        try {
            date1 = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Timestamp timestamp = new java.sql.Timestamp(date1.getTime());
        return timestamp;
    }

    private Timestamp getStartOfTheDate(String date1){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date = null;
        try {
            date = dateFormat.parse(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();       // get calendar instance
        cal.setTime(date);                           // set cal to date
        cal.set(Calendar.HOUR_OF_DAY, 0);            // set hour to midnight
        cal.set(Calendar.MINUTE, 0);                 // set minute in hour
        cal.set(Calendar.SECOND, 0);                 // set second in minute
        cal.set(Calendar.MILLISECOND, 0);            // set millis in second
        Date zeroedDate = cal.getTime();
        Timestamp timestamp = new java.sql.Timestamp(zeroedDate.getTime());
        return timestamp;
    }

    private Timestamp getEndOfTheDate(String date1){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date = null;
        try {
            date = dateFormat.parse(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
         Calendar cal = Calendar.getInstance();       // get calendar instance
        cal.setTime(date);                           // set cal to date
        cal.set(Calendar.HOUR_OF_DAY, 23);            // set hour to midnight
        cal.set(Calendar.MINUTE, 59);                 // set minute in hour
        cal.set(Calendar.SECOND, 0);                 // set second in minute
        cal.set(Calendar.MILLISECOND, 0);            // set millis in second
        Date zeroedDate = cal.getTime();
        Timestamp timestamp = new java.sql.Timestamp(zeroedDate.getTime());
        return timestamp;

    }

    @Transactional
    @Override
    public ResponseDto findRecordsFromToday(){

        Date date= new Date();

        long time = date.getTime();

        Timestamp ts = new Timestamp(time);
        return new ResponseDto(roomScheduleRepository.findByStartTimeAfter(ts));
    }

    @Transactional
    @Override
    public ResponseDto deactivateSchedule(final long id){
        ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode(),ResponseEnum.FAIL.getMsg());
        RoomCourseSchedule roomSchedule = roomScheduleRepository.getOne(id);
        if(roomSchedule != null) {
            roomSchedule.setStatus(TransactionStatus.DEACTIVE.getCode());
            roomScheduleRepository.save(roomSchedule);
            return new ResponseDto(ResponseEnum.SUCCESS.getCode(),"Room Schedule deactivated successfully");
        }
        return responseDto;
    }

    @Transactional
    @Override
    public ResponseDto activateSchedule(final long id){
        ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode(),ResponseEnum.FAIL.getMsg());
        RoomCourseSchedule roomSchedule = roomScheduleRepository.getOne(id);
        if(roomSchedule != null) {
            roomSchedule.setStatus(TransactionStatus.ACTIVE.getCode());
            roomScheduleRepository.save(roomSchedule);
            return new ResponseDto(ResponseEnum.SUCCESS.getCode(),"Room Schedule activated successfully");
        }
        return responseDto;


    }

    @Transactional
    @Override
    public Map<String, Object> getRoomScheduleData(final long id){

       RoomCourseSchedule roomCourseSchedule = roomScheduleRepository.getOne(id);
       RoomScheduleDto roomScheduleDto = EntityToDtoRoomCourse.getRoomScheduleDto(new RoomScheduleDto(),roomScheduleRepository.getOne(id));
        CourseDto courseDto = EntityToDtoCourse.getCourseDto(new CourseDto(),roomCourseSchedule.getCourse());
        ClassRoomDto classRoomDto = EntityToDtoClass.getClassDto(new ClassRoomDto(),roomCourseSchedule.getRoom());

        Map<String,Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("roomSchedule",roomCourseSchedule);
        stringObjectHashMap.put("course",courseDto);
        stringObjectHashMap.put("room",classRoomDto);
//        return new ResponseDto(EntityToDtoRoomCourse.getRoomScheduleDto(new RoomScheduleDto(),roomScheduleRepository.getOne(id)));
        return stringObjectHashMap;
    }

}
