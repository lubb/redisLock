package com.lbb.lock.redisLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeckillServiceImpl {

    @Autowired
    private RedisLock redisLock;

    private static final int TIMEOUT = 10*1000;//超时时间 10s

    int n = 500;

    public void orderProductMocckDiffUser(String productId) throws Exception {//解决方法一:synchronized锁方法是可以解决的，但是请求会变慢,请求变慢是正常的。主要是没做到细粒度控制。比如有很多商品的秒杀，但是这个把所有商品的秒杀都锁住了。而且这个只适合单机的情况，不适合集群
        //加锁
        long time = System.currentTimeMillis() + TIMEOUT;
        redisLock.lock(productId,String.valueOf(time));
        System.out.println(Thread.currentThread().getName() + "获得了锁");
        System.out.println(--n);
        //解锁
        redisLock.unlock(productId,String.valueOf(time));
    }
}
