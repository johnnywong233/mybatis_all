package com.johnny.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class StudentLecture implements Serializable {
    private Integer id;
    private Integer studentId;
    private Lecture lecture;
    private BigDecimal grade;
    private String note;
}