package com.byport.scheduler.entity;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @Column(name="is_completed")
    private Boolean isCompleted;
    @Column(name = "date_start")
    private Date start;
    @Column(name = "date_end")
    private Date end;
    @Column(name = "date_completed")
    private Date dateCompleted;
    
    @ManyToOne
    @JoinColumn(name="employee")
    @JsonIgnore
    private Employee employee;
}
