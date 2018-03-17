package com.johnny.demo_6_1_2;

/**
 * 6-1-2 JDK动态代理
 */
public class HelloServiceMain {
    public static void main(String[] args) {
        HelloServiceProxy helloServiceProxy = new HelloServiceProxy();
        HelloService proxy = (HelloService) helloServiceProxy.bind(new HelloServiceImpl());
        proxy.sayHello("张三!");
    }
}