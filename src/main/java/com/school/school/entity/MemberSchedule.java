package com.school.school.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "member_schedule")
public class MemberSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "member_id")
    private Integer memberId;

    @Column(name = "exercise_id")
    private Integer exerciseId;

    @Column(name = "schedule_id")
    private Integer scheduleId;

    @Column(name = "status")
    private String status;

    @Column(name = "no_of_sets")
    private Integer noOfSets;

    @Column(name = "no_of_reps")
    private Integer noOfReps;

    @Column(name = "date_created")
    private Date dateCreated;

    public MemberSchedule() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Integer exerciseId) {
        this.exerciseId = exerciseId;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getNoOfSets() {
        return noOfSets;
    }

    public void setNoOfSets(Integer noOfSets) {
        this.noOfSets = noOfSets;
    }

    public Integer getNoOfReps() {
        return noOfReps;
    }

    public void setNoOfReps(Integer noOfReps) {
        this.noOfReps = noOfReps;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
