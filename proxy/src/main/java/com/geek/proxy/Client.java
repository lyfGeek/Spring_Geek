package com.geek.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
         * 基于接口的动态代理。
         *      涉及的类：Proxy。
         *      提供者：JDK 官方。
         *
         * 如何创建代理对象。
         *      使用 Proxy 类中的 newProxyInstance(); 方法。
         *
         * 创建代理对象的要求。
         *      被代理类至少实现一个接口，如果没有则不能使用。
         *
         * newInstance() 方法的参数。
         *      + newInstance() 方法的参数。
         *
         * > + loader: ClassLoader ——> 类加载器。
         * > ～ 用于加载代理对象的字节码。和被代理对象使用相同的类加载器。（固定写法。.getClass().getClassLoader()）。
         * >
         * > + interfaces: Class<?>[]
         * > ～ 用于让代理对象和被代理对象有相同的方法。（有相同的方法：实现同一接口）。（固定写法。.getClass().getInterfaces()）。
         * >
         * > + h: InvocationHandler
         * > ～ 让我们写：如何代理。（用于提供增强的方法）。
         * > 一般写一个该接口的实现类（一般是匿名内部类，但不是必须的）。此接口的实现类是谁用谁写。
         */
        IProducer proxyInstance = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 执行被代理对象的任何接口方法都会经过该方法。
                     * @param proxy     代理对象的引用。
                     * @param method    当前执行的方法。
                     * @param args      当前执行的方法所需要的参数。
                     * @return 和被代理对象有相同的返回值。
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        Object returnValue = null;

                        // 增强的代码。
                        // 获取方法执行的参数。
                        float money = (float) args[0];
                        // 判断当前方法是不是销售。
                        if ("saleProduct".equals(method.getName())) {
                            returnValue = method.invoke(producer, money * 0.8f);// 经销商拿走 20%。
                        }
//                        return null;
//                        return method.invoke(producer, args);
                        return returnValue;
                    }
                });
        proxyInstance.saleProduct(10000f);
    }
}
