package com.johnny.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Student implements Serializable {
    private Integer id;
    private String cnName;
    private SexEnum sex;
    private String selfCardNo;
    private String note;
    private StudentSelfCard studentSelfcard;
    private List<StudentLecture> studentLectureList;
}