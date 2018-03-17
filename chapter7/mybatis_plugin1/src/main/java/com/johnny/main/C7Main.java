package com.johnny.main;

import com.johnny.dao.RoleDao;
import com.johnny.pojo.Role;
import com.johnny.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class C7Main {
    private static final Logger log = LogManager.getLogger(C7Main.class);

    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        RoleDao roleDao = sqlSession.getMapper(RoleDao.class);

        Role role = new Role();
        role.setRoleName("lym");
        role.setNote("wj");
        roleDao.insertRole(role);

        log.info("执行成功!");
    }
}