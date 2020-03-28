package com.geek.service.impl;

import com.geek.dao.IAccountDao;
import com.geek.service.IAccountService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/*
 * 账户的业务层实现类。
 *
 * <bean id="accountService" class="com.geek.service.impl.AccountServiceImpl"
 *      scope="" init-method="" destroy-method="">
 *      <property name="" value="" ref=""></property>
 *     </bean>
 *
 * 用于创建对象的注解。
 *      ==> xml 中的 <bean></bean> 标签。
 *          ==> @Component
 *              把当前类对象存入 Spring 容器。
 *              属性：
 *                  value：指定 bean 的 id。
 *                  如果不写，ta 的默认值是当前类名，首字母小写。
 *          ==> @Controller 表现层。
 *          ==> @Service 业务层。
 *          ==> @Repository 持久层。
 *              作用和 @Component 一样。
 *
 * 用于注入数据的注解。
 *      ==> xml 中的 bean 标签中 <property></property>。
 *      @Autowired
 *          自动按照类型注入。只要容器中有唯一一个 bean 对象类型和要注入的变量类型匹配，就可以注入成功。
 *          如果 IoC 容器中有多个类型匹配时，先按类型变量名称，再根据变量名称。
 *
 *          set 方法可以不要了。
 *
 *      @Qualifier
 *          在按照类型注入的基础上再按名称注入。
 *          属性。
 *              value：指定注入 bean 的 id。
 *
 * 用于改变作用范围的注解。
 *      ==> xml 中的 bean 标签中 scope 属性。
 * 生命周期相关。
 *      ==> xml 中的 bean 标签中 init-method="" destroy-method=""。
 */
@Component("accountService")
public class AccountServiceImpl implements IAccountService {

//    @Autowired
//    @Qualifier("accountDao01")
//    private IAccountDao accountDao = null;
////    private IAccountDao accountDao02 = null;

    @Resource(name = "accountDao02")
    private IAccountDao accountDao;

    public AccountServiceImpl() {
        System.out.println("默认构造方法。（对象创建了）。");
    }

    public void saveAccount() {
        accountDao.save();
    }
}
