package com.geek.proxy;

/**
 * 生产者。
 */
public class Producer implements IProducer {

    /**
     * 销售。
     *
     * @param money
     */
    public void saleProduct(float money) {
        System.out.println("销售产品，并拿到钱：" + money);
    }

    /**
     * 售后。
     *
     * @param money
     */
    public void afterMarket(float money) {
        System.out.println("提供售后服务，并拿到钱：" + money);
    }
}
