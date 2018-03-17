package com.johnny.dao;

import com.johnny.pojo.StudentLecture;

import java.util.List;


public interface StudentLectureDao {

    List<StudentLecture> findStudentLectureByStudentId(Integer id);

}
