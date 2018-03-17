package com.johnny.dao;

import com.johnny.pojo.Student;

import java.util.List;


public interface StudentDao {
    Student getStudent(Integer id);

    List<Student> findAllStudent();
}
