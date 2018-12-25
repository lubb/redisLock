package com.lbb.lock.redisLock;

public class ThreadA extends Thread {

    private SeckillServiceImpl service;

    public ThreadA(SeckillServiceImpl service) {
        this.service = service;
    }

    @Override
    public void run() {
        try{
            service.orderProductMocckDiffUser("123456");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
