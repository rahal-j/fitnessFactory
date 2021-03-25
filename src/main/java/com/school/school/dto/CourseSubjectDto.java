package com.school.school.dto;

import java.io.Serializable;
import java.util.List;

public class CourseSubjectDto implements Serializable {


    private String course;

    private List<String> subjects ;

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }
}
