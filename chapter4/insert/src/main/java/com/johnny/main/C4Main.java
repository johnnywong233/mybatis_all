package com.johnny.main;

import com.johnny.dao.RoleDao;
import com.johnny.pojo.Role;
import com.johnny.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 4.3 : Insert元素.
 */
public class C4Main {

    private static Logger logger = LogManager.getLogger(C4Main.class.getName());

    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleDao roleDao = sqlSession.getMapper(RoleDao.class);
            Role param = new Role();
            param.setRoleName("me11");
            param.setNote("te22");
            System.out.println(roleDao.insertRole(param));
            System.out.println(param.getId());
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