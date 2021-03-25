package com.school.school.entity;
// Generated Dec 21, 2019 1:36:33 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Subject generated by hbm2java
 */
@Entity
@Table(name="subject"
    ,catalog="school_db"
)
public class Subject  implements java.io.Serializable {


     private Long id;
     private String name;
     private String status;

    public Subject() {
    }

    public Subject(String name, String status) {
       this.name = name;
       this.status = status;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    
    @Column(name="name", nullable=false, length=50, unique = true)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="status", nullable=false, length=20)
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }




}


