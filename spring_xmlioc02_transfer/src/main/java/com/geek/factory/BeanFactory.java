package com.geek.factory;

import com.geek.service.IAccountService;
import com.geek.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建 Service 的代理对象工厂。
 */
public class BeanFactory {

    private IAccountService accountService;

    private TransactionManager transactionManager;

    public final void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    /**
     * 获取 Service 代理对象。
     *
     * @return
     */
    public IAccountService getAccountService() {
        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        // test(); 方法不支持事务。此时，test(); 方法是连接点，但不是切入点，因为没有实现增强。
                        if ("test".equals(method.getName())) {
                            return method.invoke(accountService, args);
                        }

                        Object rtValue = null;
                        try {
                            // 开启事务。
                            transactionManager.beginTransaction();
                            // 执行操作。
                            rtValue = method.invoke(accountService, args);
                            // 提交事务。
                            transactionManager.commitTransaction();
                            return rtValue;
                        } catch (Exception e) {
                            e.printStackTrace();
                            // 回滚操作。
                            transactionManager.rollbackTransaction();
                            throw new RuntimeException(e);
                        } finally {
                            // 释放连接。
                            transactionManager.release();
                        }
                    }
                });
    }

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }
}
