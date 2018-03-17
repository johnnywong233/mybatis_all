package com.johnny.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 男学生
 */
@Data
public class MaleStudent extends Student implements Serializable {
    private List<StudentHealthMale> studentHealthMaleList = null;
}