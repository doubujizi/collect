package com.dou.tfx.prefect.thread;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/10/29 15:38
 */
public class ZeroEvenOdd {
    private int n;
    private Semaphore semaphoreZero = new Semaphore(1);
    private Semaphore semaphoreEven = new Semaphore(0);
    private Semaphore semaphoreOdd = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            semaphoreZero.acquire();
            printNumber.accept(0);
            if (i % 2 == 1) {
                semaphoreOdd.release();
            } else {
                semaphoreEven.release();
            }


        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            semaphoreEven.acquire();
            printNumber.accept(i);
            semaphoreZero.release();
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        Integer  aaa  = 1;
        for (int i = 1; i <= n; i += 2) {
            semaphoreOdd.acquire();
            printNumber.accept(i);
            semaphoreZero.release();
        }

    }
}
