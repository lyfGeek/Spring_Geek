package com.geek.log;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 用于记录日志的工具类。提供公共代码。
 */
public class Logger {
    /**
     * 前置增强。
     */
    public void beforePrintLog() {
        System.out.println("Logger 类中的 beforePrintLog(); 方法开始记录日志了。");
    }

    /**
     * 后置增强。
     */
    public void afterReturningPrintLog() {
        System.out.println("Logger 类中的 afterReturningPrintLog(); 方法开始记录日志了。");
    }

    /**
     * 异常增强。
     */
    public void afterThrowingPrintLog() {
        System.out.println("Logger 类中的 afterThrowingPrintLog(); 方法开始记录日志了。");
    }

    /**
     * 最终增强。
     */
    public void afterPrintLog() {
        System.out.println("Logger 类中的 afterPrintLog(); 方法开始记录日志了。");
    }

    /**
     * 环绕通知。
     * <p>
     * 当配置环绕通知后，切入点方法没有执行，而环绕通知方法执行了。
     * <p>
     * 对比动态代理中环绕的代码，动态代理的环绕通知有明确的切入点方法调用。
     * <p>
     * Spring 框架为我们提供了一个接口，ProceedingJoinPoint，该接口有一个方法 proceed()。
     * 此方法就相当于调用切入点的方法。
     * 该接口可以作为环绕通知的方法参数。在程序执行时，Spring 框架会为我们提供该接口的实现类供我们使用。
     */
    public Object aroundPrintLog(ProceedingJoinPoint pjp) {
        Object rtValue = null;
        try {
            Object[] args = pjp.getArgs();

            System.out.println("Logger 类中的 aroundPrintLog(); 方法开始记录日志了。前置。");

            rtValue = pjp.proceed(args);// 明确调用切入点方法。

            System.out.println("Logger 类中的 aroundPrintLog(); 方法开始记录日志了。后置。");

            return rtValue;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("Logger 类中的 aroundPrintLog(); 方法开始记录日志了。异常。");
            throw new RuntimeException(throwable);
        } finally {
            System.out.println("Logger 类中的 aroundPrintLog(); 方法开始记录日志了。最终。");
        }

    }
}
