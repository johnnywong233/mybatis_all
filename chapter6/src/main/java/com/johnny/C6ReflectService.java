package com.johnny;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 6.1.1 反射技术.
 */
public class C6ReflectService {

    public static void main(String[] args) throws ClassNotFoundException
            , NoSuchMethodException, InstantiationException, IllegalAccessException
            , IllegalArgumentException, InvocationTargetException {
        // 通过反射创建ReflectService对象.
        Object service = Class.forName(C6ReflectService.class.getName()).newInstance();
        // 获取服务方法.
        Method method = service.getClass().getMethod("sayHello", String.class);
        // 反射调用方法.
        method.invoke(service, "张三");
    }

    /**
     * 服务方法
     *
     * @param name 姓名
     */
    public void sayHello(String name) {
        System.err.println("hello," + name);
    }
}