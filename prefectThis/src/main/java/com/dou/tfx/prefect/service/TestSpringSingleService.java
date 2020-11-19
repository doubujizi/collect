package com.dou.tfx.prefect.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/11/18 11:24
 */
@Service
public class TestSpringSingleService {
    private static ReentrantLock reentrantLock = new ReentrantLock();
    public void testA() {

        for (int i = 0; i < 1000; i++) {
            try {
                System.out.println(Thread.currentThread().getName());
                System.out.println(i);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void testB(){
        System.out.println(Thread.currentThread().getName());
        boolean locked = reentrantLock.isLocked();
        System.out.println(locked);
        reentrantLock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"开始干活");
            //业务 200s
            for(int i=0;i<200;i++){
                System.out.println(i);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }
}
