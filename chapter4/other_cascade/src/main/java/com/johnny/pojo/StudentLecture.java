package com.johnny.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StudentLecture {
    private Integer id;
    private Integer studentId;
    private Lecture lecture;
    private BigDecimal grade;
    private String note;
}