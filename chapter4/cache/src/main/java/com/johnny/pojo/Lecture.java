package com.johnny.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Lecture implements Serializable {
    private Integer id;
    private String lectureName;
    private String note;
}