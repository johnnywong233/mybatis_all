package com.johnny.pojo;

import lombok.Data;

import java.util.List;

@Data
public class MaleStudent extends Student {
    private List<StudentHealthMale> studentHealthMaleList = null;
}
