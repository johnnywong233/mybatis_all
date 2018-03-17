package com.johnny.main;

import com.johnny.dao.RoleDao;
import com.johnny.pojo.Role;
import com.johnny.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 4.4 :
 * update和delete元素.
 */
public class C4Main {

    private static Logger logger = LogManager.getLogger(C4Main.class.getName());

    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleDao roleDao = sqlSession.getMapper(RoleDao.class);
            Role param = new Role();
            param.setId(2);
            param.setRoleName("12222");
            param.setNote("3333");
            roleDao.updateRole(param);
            roleDao.selectAllData().forEach(x -> System.out.println(x.toString()));
            System.out.println("-------------------------------------------------------------->");
            roleDao.deleteRole(2);
            roleDao.selectAllData().forEach(x -> System.out.println(x.toString()));
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
