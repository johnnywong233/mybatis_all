package com.johnny.pojo;

import lombok.Data;

import java.util.List;

@Data
public class FemaleStudent extends Student {
    private List<StudentHealthFemale> studentHealthFemaleList = null;
}
