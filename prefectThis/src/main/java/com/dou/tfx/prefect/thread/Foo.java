package com.dou.tfx.prefect.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/8/25 14:10
 */
class Foo {
    private final CountDownLatch countDownLatchFirst = new CountDownLatch(1);
    private final CountDownLatch countDownLatchSecond = new CountDownLatch(1);
    public Foo() {

    }


    public void first(Runnable printFirst) throws InterruptedException {

        System.out.println("first");
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        countDownLatchFirst.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        countDownLatchFirst.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        System.out.println("second");
        countDownLatchSecond.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        countDownLatchSecond.await();
        System.out.println("third");
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
