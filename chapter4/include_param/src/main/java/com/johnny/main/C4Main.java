package com.johnny.main;

import com.johnny.dao.RoleDao;
import com.johnny.pojo.Role;
import com.johnny.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * 4.6 :
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
            param.setRoleName("me111123123459");
            param.setNote("te22upouidateaer");
            System.out.println(roleDao.getRole(5).toString());
            System.out.println("-------------------------------------------------------------->");
            System.out.println(roleDao.getRoleCustom(5).toString());
            System.out.println("-------------------------------------------------------------->");
            Map<String, String> maps = new HashMap<>(2);
            maps.put("roleName", "me");
            maps.put("note", "te");
            roleDao.findRoles(maps).forEach(x -> System.out.println(x.toString()));
            /*
            List<Role> getRoleCustom(Integer id);
            List<Role> findRoles(Map<String,String> params);
            List<Role> getRole(Integer id);
             */
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