package com.geek.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 模拟一个消费者。
 */
public class Client {

    public static void main(String[] args) {
        Producer producer = new Producer();

//        producer.saleProduct(10000F);

        /**
         * 动态代理。
         *
         * 特点：字节码随用随创建，随用随加载。
         * 作用：不修改源码的基础上对方法增强。
         * 分类。
         *      基于接口的动态代理。
         *      基于子类的动态代理。
         *
         * 基于子类口的动态代理。
         *      涉及的类：Enhancer。
         *      提供者：第三方 cglib 库。
         *
         * 如何创建代理对象。
         *      使用 Enhancer 类中的 create(); 方法。
         *
         * 创建代理对象的要求。
         *      被代理类不能是最终类。（需要有子类）。
         *
         * create() 方法的参数。
         * > ～ 让我们写：如何代理。（用于提供增强的方法）。
         * > 一般写一个该接口的实现类（一般是匿名内部类，但不是必须的）。此接口的实现类是谁用谁写。
         * > 我们一般写的都是该接口的子接口实现类：new MethodInterceptor() {
         *
         */
        Producer cglibProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             * 执行被代理对象的任何方法都会经过此方法。
             * @param o             proxy。
             * @param method
             * @param objects       args。
             * ～ ～ ～ ～ ～ ～ ～ 以上三个参数和基于接口的动态代理 invoke(); 方法的参数一样。
             * @param methodProxy   当前执行方法的代理对象。
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

                Object returnValue = null;

                // 增强的代码。
                // 获取方法执行的参数。
                float money = (float) objects[0];
                // 判断当前方法是不是销售。
                if ("saleProduct".equals(method.getName())) {
                    returnValue = method.invoke(producer, money * 0.8f);// 经销商拿走 20%。
                }
//                        return null;
//                        return method.invoke(producer, args);
                return returnValue;
            }
        });
        cglibProducer.saleProduct(12000F);
    }
}
