package com.school.school.repository;

import com.school.school.entity.Course;
import com.school.school.entity.Room;
import com.school.school.entity.RoomCourseSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface RoomScheduleRepository extends JpaRepository<RoomCourseSchedule,Long> {




    List<RoomCourseSchedule> findByRoomAndEndTimeGreaterThanOrEndTimeLessThan(Room room, Timestamp startTime,Timestamp endTime);



     @Query(value = "SELECT * FROM room_course_schedule WHERE room_id=?1 AND end_time BETWEEN ?2 AND ?3", nativeQuery =
            true)
     List<RoomCourseSchedule> findRoomSchedulesByStartAndEndDatesAndRoomId(long roomId,Timestamp startTime,Timestamp endTime);


     List<RoomCourseSchedule> findByCourseAndStartTimeAfter(Course course,Timestamp timestamp);

    List<RoomCourseSchedule> findByStartTimeAfter(final Timestamp startTime);
}


