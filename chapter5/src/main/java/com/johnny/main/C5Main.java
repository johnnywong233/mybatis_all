package com.johnny.main;

import com.johnny.dao.RoleDao;
import com.johnny.dao.UserDao;
import com.johnny.pojo.Role;
import com.johnny.pojo.User;
import com.johnny.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

/**
 * 第五章所有例子.
 * 5.2 if元素
 * 5.3 choose,when,otherwise元素
 * 5.4 trim,where,set元素
 * 5.5 foreach元素
 * 5.6 test的属性
 * 5.7 bind元素
 */
public class C5Main {

    private static final Logger log = LogManager.getLogger(C5Main.class);

    public static void main(String[] args) {
        SqlSession sqlSession;
        sqlSession = SqlSessionFactoryUtil.openSqlSession();
        RoleDao roleDao = sqlSession.getMapper(RoleDao.class);

        execute52(roleDao);

        execute53(roleDao);

        execute54(roleDao, sqlSession);// 会发生更新,请关注代码.

        execute55(sqlSession);// 代码文件在UserDao.xml

        execute56(roleDao);

        execute57(roleDao);

        log.info("执行成功!");
    }

    private static void execute52(RoleDao roleDao) {
        System.out.println("---------5.2----------->");
        roleDao.findRolesIf("test").forEach(x -> System.out.println(x.toString()));
        System.out.println("---------5.2end----------->");
    }

    private static void execute53(RoleDao roleDao) {
        System.out.println("---------5.3----------->");
        roleDao.findChooseWhenOtherWise("4", "test").forEach(x -> System.out.println(x.toString()));
        roleDao.findChooseWhenOtherWise("", "test").forEach(x -> System.out.println(x.toString()));
        System.out.println("---------5.3end----------->");
    }

    private static void execute54(RoleDao roleDao, SqlSession sqlSession) {
        System.out.println(roleDao.findWhere("test"));
        System.out.println(roleDao.findRoleTrim("更新"));

        Role role = new Role();
        role.setId(4);
        role.setRoleName("更新之后");
        role.setNote("更新备注");

        System.out.println(roleDao.updateRole(role));
        sqlSession.commit();
    }

    private static void execute55(SqlSession sqlSession) {
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.findUserBySex(Arrays.asList(0, 1, 2));
        userList.forEach(x -> System.out.println(x.toString()));
    }

    private static void execute56(RoleDao roleDao) {
        System.out.println(roleDao.getRoleTest("y"));
    }

    private static void execute57(RoleDao roleDao) {
        System.out.println(roleDao.findRoleMulBind("更新", "更新"));
    }

}