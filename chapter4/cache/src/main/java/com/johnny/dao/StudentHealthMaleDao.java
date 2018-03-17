package com.johnny.dao;

import com.johnny.pojo.StudentHealthMale;

public interface StudentHealthMaleDao {
    StudentHealthMale findStudentHealthMaleByStudentId(Integer id);
}