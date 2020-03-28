package com.geek.factory;


import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
 *
 * bean —> 计算机英语：可重用组件。
 * JavaBean ！= 实体类（可重用组件的一部分）。
 *
 * JavaBean —> 用 Java 语言编写的可重用组件。
 * 实体类（可重用组件的一部分）。
 *
 * 可重用：（相机的以疏快门键：第一次拍照都需要按下）。
 *
 * 创建 Service 和 Dao 对象的工厂。
 *
 * 需求 how：
 *      1. 一个配置文件来配置 service 和 dao。
 *          内容：—> 唯一标识=全限定类名。（key=value）。
 *      2. 通过读取配置文件中的内容，反射创建对象。（把编译期错误转为运行时异常）。
 *
 *      配置文件： xml 或 properties。
 */

/**
 * 一个创建 Bean 对象的工厂。
 */
public class BeanFactory {

    // 定义一个 properties 对象。
    private static Properties properties;

    // 定义一个 Map 用于存放我们要创建的对象，我们称之为容器。
    private static Map<String, Object> beans;

    // 使用静态代码块为 properties 对象赋值。
    static {

        try {
            // 实例化对象。
            properties = new Properties();// 耦合只能降低，不能消除。

            // 获取 properties 文件的流对象。

//        new FileInputStream("src/...")
            // web 项目不能用 src 路径。
            // 使用绝对路径不能保证每次需要的文件一样。还是存在耦合。
            // ==》
            InputStream inputStream = BeanFactory.class.getClassLoader()
                    .getResourceAsStream("bean.properties");// 创建在 resources 文件夹下的文件会成为类根路径下的文件。

            properties.load(inputStream);

            // ～～～多例。

            // 实例化容器。
            beans = new HashMap<String, Object>();
            // 取出配置文件中所有的 key。
            Enumeration<Object> keys = properties.keys();
            // 遍历枚举。
            while (keys.hasMoreElements()) {
                // 取出每个 key。
                String key = keys.nextElement().toString();
                // 根据 key 获取 value。
                String beanPath = properties.getProperty(key);
                // 反射创建对象。
                Object instance = Class.forName(beanPath).newInstance();
                // 把 key 和 value 放入容器中。
                beans.put(key, instance);
            }

        } catch (Exception e) {
//            e.printStackTrace();
            throw new ExceptionInInitializerError("初始化 properties 失败。");
        }

    }


    /**
     * 根据类的名称获取 Bean 对象。（单例）。
     *
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {
        return beans.get(beanName);
    }

    /**
     * 根据类的名称获取 Bean 对象。（多例）。
     *
     * @param beanName
     * @return
     */
    /*public static Object getBean(String beanName) {
        Object bean = null;
        String beanPath = properties.getProperty(beanName);// 从 properties 文件中获取对应全限定名。
        try {
            bean = Class.forName(beanPath).newInstance();// 每次都会调用默认构造函数创建对象。
//            System.out.println("beanPath = " + beanPath);
//            System.out.println("bean = " + bean);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return bean;
    }
*/
}
