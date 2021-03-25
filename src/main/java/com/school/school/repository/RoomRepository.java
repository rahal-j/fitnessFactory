package com.school.school.repository;

import com.school.school.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Long> {


    Room findByName(final String name);

    Room findByNameEqualsAndStatus(final String name,final String status);

    List<Room> findAllByStatus(final String status);

    List<Room> findByStatus(final String status);

}
