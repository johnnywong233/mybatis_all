package com.johnny.main;

import com.johnny.dao.UserDao;
import com.johnny.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class C4Main {

    private static Logger logger = LogManager.getLogger(C4Main.class.getName());

    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            System.out.println(userDao.countFirstName("z"));
            //roleMapper.deleteRole(1L);
            //sqlSession.commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            //sqlSession.rollback();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        logger.info("执行成功!");
    }
}
