package com.johnny.demo_6_1_3;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 6.1.3 CGLIB动态代理.
 */
public class HelloServiceCgLib implements MethodInterceptor {

    private Object target;

    /**
     * 创建代理对象.
     */
    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        //回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.err.println("我是JDK动态代理");
        Object result;
        // 反射方法前调用.
        System.err.println("我准备说hello.");
        // 执行方法,相当于调用HelloServiceImpl类的sayHello方法.
        result = methodProxy.invokeSuper(o, objects);
        // 反射方法后调用.
        System.err.println("我说过hello了.");
        return result;
    }
}