package com.johnny.demo_6_1_2;

/**
 * 6-1-2 JDK动态代理
 */
public class HelloServiceImpl implements HelloService {
    public void sayHello(String name) {
        System.err.println("hello," + name);
    }
}