package com.johnny.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FemaleStudent extends Student implements Serializable {
    private List<StudentHealthFemale> studentHealthFemaleList = null;
}