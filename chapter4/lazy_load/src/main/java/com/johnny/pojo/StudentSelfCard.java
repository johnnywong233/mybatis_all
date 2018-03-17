package com.johnny.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class StudentSelfCard {
    private Integer id;
    private Integer studentId;
    private String nativeStr;
    private Date issueDate;
    private Date endDate;
    private String note;
}