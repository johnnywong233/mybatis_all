package com.johnny.main;

import com.johnny.dao.RoleDao;
import com.johnny.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 4.7.2 :
 * 使用Map存储结果集
 * 4.7.3 :
 * 使用POJO存储结果集
 */
public class C4Main {

    private static Logger logger = LogManager.getLogger(C4Main.class.getName());

    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleDao roleDao = sqlSession.getMapper(RoleDao.class);
            System.out.println(roleDao.getRole(5).toString());
            System.out.println("-------------------------------------------------------------->");
            roleDao.findRoleByNote(5).forEach((y, z) -> System.out.println(y + "--->" + z));
            System.out.println("-------------------------------------------------------------->");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        logger.info("执行成功!");
    }
}
