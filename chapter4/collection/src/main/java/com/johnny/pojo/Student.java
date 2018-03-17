package com.johnny.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    private Integer id;
    private String cnName;
    private SexEnum sex;
    private String selfCardNo;
    private String note;
    private StudentSelfCard studentSelfcard;
    private List<StudentLecture> studentLectureList;
}