package com.jcduhdt.proxy;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-10-14
 * 对生产厂家要求的接口
 */
public interface IProducer {

    /**
     * 销售
     * @param money
     */
    public void saleProduct(float money);


    /**
     * 售后
     * @param money
     */
    public void afterService(float money);
}
