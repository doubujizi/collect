package com.dou.tfx.prefect.thread;

import java.util.concurrent.Semaphore;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/10/29 14:58
 */
public class TestFooBar {
    public static void main(String[] args) {
        FooBar fooBar = new FooBar(2);
        Semaphore semaphoreFoo = new Semaphore(1);
        Semaphore semaphoreBar = new Semaphore(0);


        new Thread(() -> {
            System.out.println(1111);
            try {
                fooBar.foo(new Thread(() -> {
                    try {
                        semaphoreFoo.acquire();
                        System.out.print("aaa");
                        semaphoreBar.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            System.out.println(222);
            try {
                fooBar.bar(new Thread(() -> {
                    try {
                        semaphoreBar.acquire();
                        System.out.print("bbb");
                        semaphoreFoo.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
