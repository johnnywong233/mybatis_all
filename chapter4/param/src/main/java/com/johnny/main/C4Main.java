package com.johnny.main;

import com.johnny.dao.RoleDao;
import com.johnny.pojo.RoleParam;
import com.johnny.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * 4.2.4.3 :
 * 使用JavaBean传递参数.
 * <p>
 * <p>
 * Created by puruidong on 2017/6/26.
 */
public class C4Main {

    private static Logger logger = LogManager.getLogger(C4Main.class.getName());

    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleDao roleDao = sqlSession.getMapper(RoleDao.class);
            RoleParam param = new RoleParam();
            param.setRoleName("me");
            param.setNote("te");
            roleDao.findRoleByParams(param).forEach(x -> System.out.println(x.toString()));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        logger.info("执行成功!");
    }
}
