package com.geek.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 配置类。
 * 作用和 bean.xml 一样。
 */
// 指定当前类是一个配置类。
@Configuration
// 当配置类作为 AnnotationConfigApplicationContext 对象创建的参数时，该注解可以不写。
// 用于通过注解指定 Spring 在创建容器时需要扫描的包。
@ComponentScan(basePackages = {"com.geek"})// == value。（属性）。
// <context:component-scan base-package="com.geek"/>
@Import(JDBCConfig.class)
public class SpringConfiguration {

}
