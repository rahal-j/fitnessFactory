package com.school.school.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "schedule")
public class Schedule {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer scheduleId;

    @Column(name = "name")
private String name;

    @Column(name = "sets")
    private int sets;

    @Column(name = "reps")
    private int reps;

    @Column(name = "member_id")
    private Integer memberId;

    @Column(name = "exercise_id")
private Integer exerciseId;

    @Column(name = "date")
    private Date date;

    public Schedule() {
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Integer exerciseId) {
        this.exerciseId = exerciseId;
    }
}
