package com.lbb.lock.redisLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private SeckillServiceImpl seckillService;

    @RequestMapping("order")
    public void order(){
        for (int i = 0; i < 50; i++) {
            ThreadA threadA = new ThreadA(seckillService);
            threadA.start();
        }
    }
}
