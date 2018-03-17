package com.johnny.interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.util.Properties;

@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class}
)})
public class MyPlugin implements Interceptor {
    // 限制表中间别名,避免表重名,所以起的怪些.
    private static final String LMT_TABLE_NAME = "limit_Table_Name_xxx";
    // 默认限制查询返回行数
    private int limit;
    private String dbType;

    /**
     * 代提拦截对象方法的内容.
     */
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
        // 分离代理对象,从而形成多次代理,通过两次循环最原始的被代理类,
        // MyBatis使用的是JDK代理.
        while (metaObject.hasGetter("h")) {
            Object object = metaObject.getValue("h");
            metaObject = SystemMetaObject.forObject(object);
        }
        // 分离最后一个代理对象的目标类
        while (metaObject.hasGetter("target")) {
            Object object = metaObject.getValue("target");
            metaObject = SystemMetaObject.forObject(object);
        }
        // 取出即将要执行的SQL.
        String sql = (String) metaObject.getValue("delegate.boundSql.sql");

        String limitSql;
        // 判断参数是不是MySQL数据库且SQL有没有被插件重写过.
        if ("mysql".equals(this.dbType) && !sql.contains(LMT_TABLE_NAME) && sql.contains("select")) {
            // 去掉前后空格
            sql = sql.trim();
            // 将参数写入SQL.
            limitSql = "select * from (" + sql + ") " + LMT_TABLE_NAME + " limit " + limit;
            //重写要执行的SQL.
            metaObject.setValue("delegate.boundSql.sql", limitSql);
        }
        // 调用原来对象的方法,进入责任链的下一层级.
        return invocation.proceed();
    }

    /**
     * 生成对象的代理,这里常用MyBatis提供的Plugin类的wrap方法
     */
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    /**
     * 获取插件配置的属性,我们在MyBatis的配置文件里面去配置
     */
    public void setProperties(Properties properties) {
        String strLimit = properties.getProperty("limit", "50");
        this.limit = Integer.parseInt(strLimit);
        this.dbType = properties.getProperty("dbtype", "mysql");
    }
}