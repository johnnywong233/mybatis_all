package com.johnny.main;

import com.johnny.dao.StudentDao;
import com.johnny.pojo.Student;
import com.johnny.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 4.7.4.3 -- discriminator鉴别器级联.
 * ------------------------------------
 * <p>
 * <p>
 * MaleStudent未显示列表数据.
 * FemaleStudent未显示列表数据.
 * <p>
 * Created by puweidong on 2017/7/9.
 */
public class C4Main {

    private static Logger logger = LogManager.getLogger(C4Main.class);

    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
            Student student = studentDao.getStudent(1);
            System.out.println(student.toString());
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        logger.info("执行成功!");

    }
}
