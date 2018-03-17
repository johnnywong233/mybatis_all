package com.johnny.main;

import com.johnny.dao.StudentDao;
import com.johnny.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 4.7.4.1 -- 一对一级联
 */
public class C4Main {

    private static Logger logger = LogManager.getLogger(C4Main.class);

    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
            System.out.println(studentDao.getStudent(1));
            System.out.println(studentDao.getStudent(2));
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        logger.info("执行成功!");
    }
}