package com.school.school.entityToDtoMapper;

import com.school.school.dto.ClassRoomDto;
import com.school.school.entity.Room;
import com.school.school.enums.TransactionStatus;

public class EntityToDtoClass {


    public static ClassRoomDto getClassDto(ClassRoomDto classRoomDto, Room room){
        classRoomDto.setId(room.getId());
        classRoomDto.setName(room.getName());
        classRoomDto.setStatus(TransactionStatus.valueOf(room.getStatus()).getCode());
        return classRoomDto;
    }
}
