package com.school.school.service;

import com.school.school.dto.ClassRoomDto;
import com.school.school.dto.ResponseDto;
import com.school.school.entity.Room;

public interface ClassRoomService {
    ResponseDto saveClassRoom(ClassRoomDto classRoomDto);

    ResponseDto deactivateClassRoom(long id);

    ResponseDto activateClassRoom(long id);

    ResponseDto updateClassRoom(ClassRoomDto classRoomDto);

    ResponseDto fetchAll();

    ResponseDto getClassData(long id);

    ResponseDto getActiveClasses();

    Room getRoom(long id);
}
