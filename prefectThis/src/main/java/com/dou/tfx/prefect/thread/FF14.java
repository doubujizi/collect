package com.dou.tfx.prefect.thread;

import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/8/26 15:04
 */
public class FF14 {
    private final Semaphore tSem = new Semaphore(2);
    private final Semaphore nSem = new Semaphore(2);
    private final Semaphore dSem = new Semaphore(4);
    private final CyclicBarrier barrier = new CyclicBarrier(8);

    public FF14() {

    }

    public void tSem(Runnable tSemRelease) throws InterruptedException {
        tSem.acquire();
        try {
            barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        tSemRelease.run();
        tSem.release();
    }

    public void nSem(Runnable nSemRelease) throws InterruptedException {
        nSem.acquire();
        try {
            barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        // releaseOxygen.run() outputs "H". Do not change or remove this line.
        nSemRelease.run();
        nSem.release();
    }

    public void dSem(Runnable dSemRelease) throws InterruptedException {
        dSem.acquire();
        try {
            barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        // releaseOxygen.run() outputs "H". Do not change or remove this line.
        dSemRelease.run();
        dSem.release();
    }

    public ConcurrentHashMap<String,Object> count(){
        ConcurrentHashMap<String,Object> map = new ConcurrentHashMap<>();
        int i = dSem.availablePermits();
        int j = nSem.availablePermits();
        int k = tSem.availablePermits();
        map.put("tSem",k);
        map.put("nSem",j);
        map.put("dSem",i);
        return map;

    }
}
