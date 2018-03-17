package com.johnny.main;

import com.johnny.dao.StudentDao;
import com.johnny.pojo.Student;
import com.johnny.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 4.8.1 -- 缓存
 */
public class C4Main {

    private static Logger logger = LogManager.getLogger(C4Main.class);

    public static void main(String[] args) {
        SqlSession sqlSession = null;
        SqlSession sqlSession2 = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
            Student student = studentDao.getStudent(1);
            logger.info("使用同一个sqlSession再执行一次");
            Student student1 = studentDao.getStudent(1);
            // 请注意,当我们使用二级缓存的时候,sqlSession调用了commit方法后才会生效.
            sqlSession.commit();
            logger.info("现在创建一个新的sqlSession再执行一次");
            sqlSession2 = SqlSessionFactoryUtil.openSqlSession();
            StudentDao studentDao1 = sqlSession2.getMapper(StudentDao.class);
            Student student2 = studentDao1.getStudent(1);
            // 请注意,当我们使用二级缓存的时候,sqlSession调用了commit方法后才会生效
            sqlSession2.commit();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (sqlSession2 != null) {
                sqlSession2.close();
            }
        }
        logger.info("执行成功!");
    }
}