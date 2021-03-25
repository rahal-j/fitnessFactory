package com.school.school.service.impl;

import com.school.school.dto.ClassRoomDto;
import com.school.school.dto.ResponseDto;
import com.school.school.dtoToEntityMapper.DtoToEntityMapperClass;
import com.school.school.entity.Room;
import com.school.school.entityToDtoMapper.EntityToDtoClass;
import com.school.school.enums.ResponseEnum;
import com.school.school.enums.TransactionStatus;
import com.school.school.repository.RoomRepository;
import com.school.school.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {

    @Autowired
    RoomRepository roomRepository;

    @Override
    public ResponseDto saveClassRoom(ClassRoomDto classRoomDto) {

       /*  Room room = roomRepository.findByNameEqualsAndStatus(classRoomDto.getName().trim(),TransactionStatus.ACTIVE.getCode());
        if(room != null){
            responseDto.setMessage("Class Room Already Exist !");
        }else{*/

        try {
            roomRepository.save(DtoToEntityMapperClass.getClassRoom(new Room(), classRoomDto));
            return new ResponseDto(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMsg());

        } catch (Exception e) {
            return new ResponseDto(ResponseEnum.FAIL.getCode(), "Class Room Already Exist !");
        }
    }

    @Override
    public ResponseDto deactivateClassRoom(final long id) {
        ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode(), ResponseEnum.FAIL.getMsg());
        Room room = roomRepository.getOne(id);
        if (room != null) {
            room.setStatus(TransactionStatus.DEACTIVE.getCode());
            roomRepository.save(room);
            return new ResponseDto(ResponseEnum.SUCCESS.getCode(), "Class room deactivated successfully");
        }
        return responseDto;
    }

    @Override
    public ResponseDto activateClassRoom(final long id) {
        ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode(), ResponseEnum.FAIL.getMsg());
        Room room = roomRepository.getOne(id);
        if (room != null) {
            room.setStatus(TransactionStatus.ACTIVE.getCode());
            roomRepository.save(room);
            return new ResponseDto(ResponseEnum.SUCCESS.getCode(), "Class room activated successfully");
        }
        return responseDto;
    }

    @Override
    public ResponseDto updateClassRoom(ClassRoomDto classRoomDto) {
        ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode(), ResponseEnum.FAIL.getMsg());
        Room room = roomRepository.findByName(classRoomDto.getName());
        if (room != null) {
            roomRepository.save(DtoToEntityMapperClass.getClassRoom(room, classRoomDto));
            return new ResponseDto(ResponseEnum.SUCCESS.getCode(), "Class room updated successfully");

        }
        return responseDto;
    }

    @Override
    public ResponseDto fetchAll() {
        return new ResponseDto(roomRepository.findAll());
    }


    @Override
    public ResponseDto getClassData(final long id) {

        Room room = roomRepository.getOne(id);

        return new ResponseDto(EntityToDtoClass.getClassDto(new ClassRoomDto(), room));
    }

    @Transactional
    @Override
    public ResponseDto getActiveClasses(){
        return new ResponseDto(roomRepository.findAllByStatus(TransactionStatus.ACTIVE.getCode()));
    }

    @Transactional
    @Override
    public Room getRoom(long id){
        return roomRepository.getOne(id);
    }

}
