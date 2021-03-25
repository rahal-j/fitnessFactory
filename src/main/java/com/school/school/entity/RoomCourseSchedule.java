package com.school.school.entity;
// Generated Dec 21, 2019 1:36:33 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * RoomCourseSchedule generated by hbm2java
 */
@Entity
@Table(name="room_course_schedule"
    ,catalog="school_db"
)
public class RoomCourseSchedule  implements java.io.Serializable {


     private Long id;
     private Course course;
     private Room room;
     private Date startTime;
     private Date endTime;
     private String status;
     private String createdUser;
     private Date createdTime;

    public RoomCourseSchedule() {
    }

	
    public RoomCourseSchedule(Course course, Room room, String status) {
        this.course = course;
        this.room = room;
        this.status = status;
    }
    public RoomCourseSchedule(Course course, Room room, Date startTime, Date endTime, String status, String createdUser, Date createdTime) {
       this.course = course;
       this.room = room;
       this.startTime = startTime;
       this.endTime = endTime;
       this.status = status;
       this.createdUser = createdUser;
       this.createdTime = createdTime;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="course_id", nullable=false)
    public Course getCourse() {
        return this.course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="room_id", nullable=false)
    public Room getRoom() {
        return this.room;
    }
    
    public void setRoom(Room room) {
        this.room = room;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="start_time", length=19)
    public Date getStartTime() {
        return this.startTime;
    }
    
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="end_time", length=19)
    public Date getEndTime() {
        return this.endTime;
    }
    
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    
    @Column(name="status", nullable=false, length=20)
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    
    @Column(name="created_user", length=50)
    public String getCreatedUser() {
        return this.createdUser;
    }
    
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_time", length=19)
    public Date getCreatedTime() {
        return this.createdTime;
    }
    
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }




}


