package com.example.Attendence.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentSummaryDTO {
    private Long id;
    private String name;
    private int totalClasses;
    private int present;
    private double percentage;
}
