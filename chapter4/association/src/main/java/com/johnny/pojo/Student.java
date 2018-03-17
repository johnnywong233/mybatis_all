package com.johnny.pojo;

import lombok.Data;

@Data
public class Student {
    private Integer id;
    private String cnName;
    private SexEnum sex;
    private String selfCardNo;
    private String note;
    private StudentSelfCard studentSelfcard;
}