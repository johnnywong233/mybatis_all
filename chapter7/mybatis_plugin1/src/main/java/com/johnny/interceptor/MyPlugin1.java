package com.johnny.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}
)})
public class MyPlugin1 implements Interceptor {

    private Properties props = null;

    /**
     * 代提拦截对象方法的内容.
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.err.println("before......");
        /*
        如果当前代理的是一个非代理对象,那么它就回调用真实拦截对象的方法,
        如果不是,它会调度下个插件代理对象的invoke方法.
         */
        Object obj = invocation.proceed();
        System.err.println("after......");
        return obj;
    }

    /**
     * 生成对象的代理,这里常用MyBatis提供的Plugin类的wrap方法
     */
    @Override
    public Object plugin(Object o) {
        // 使用MyBatis提供的Plugin类生成代理对象.
        System.err.println("调用生成代理对象");
        return Plugin.wrap(o, this);
    }

    /**
     * 获取插件配置的属性,我们在MyBatis的配置文件里面去配置
     */
    @Override
    public void setProperties(Properties properties) {
        System.err.println(properties.get("dbType"));
        this.props = properties;
    }
}