package com.school.school.dtoToEntityMapper;

import com.school.school.dto.ClassRoomDto;
import com.school.school.entity.Room;
import com.school.school.enums.TransactionStatus;

public class DtoToEntityMapperClass {

    public static Room getClassRoom(Room room, ClassRoomDto classRoomDto){
        room.setId(classRoomDto.getId()!= null?classRoomDto.getId(): null);
        room.setName(classRoomDto.getName());
        room.setStatus(TransactionStatus.valueOf(classRoomDto.getStatus()).getCode());
        return room;
    }


}
