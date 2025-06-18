package com.example.Attendence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
@Entity
@Data
@AllArgsConstructor
public class Subject {

    @Id
    private Long id;


    private String name;
    private int present;
    private int total;

}
