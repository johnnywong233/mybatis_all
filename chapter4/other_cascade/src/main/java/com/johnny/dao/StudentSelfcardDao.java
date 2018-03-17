package com.johnny.dao;

import com.johnny.pojo.StudentSelfCard;


public interface StudentSelfcardDao {

    StudentSelfCard findStudentSelfcardByStudentId(Integer studentId);
}
