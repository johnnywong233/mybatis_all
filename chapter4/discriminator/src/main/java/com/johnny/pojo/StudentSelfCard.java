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

    @Override
    public String toString() {
        return id + "---->" + studentId + "---->" + nativeStr + "---->" +
                issueDate.toInstant().toString() + "---->" + endDate.toInstant().toString() + "---->" + note;
    }
}