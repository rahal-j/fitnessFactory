package com.school.school.entity;


import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

@Column (name = "name")
private String name;

@Column (name = "status")
private String status;


    public UserRole() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
