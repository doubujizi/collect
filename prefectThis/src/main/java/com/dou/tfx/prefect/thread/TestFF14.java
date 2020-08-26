package com.dou.tfx.prefect.thread;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/8/26 15:19
 */
public class TestFF14 {
    public static void main(String[] args) {
        FF14 ff14 = new FF14();
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {

                try {
                    ff14.tSem(() -> {
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {

                try {
                    ff14.nSem(() -> {
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
        }
        for (int i = 0; i < 4; i++) {

            new Thread(() -> {

                try {
                    ff14.dSem(() -> {
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
        }

        new Thread(() -> {
            for(;;){
                ConcurrentHashMap<String, Object> count = ff14.count();
                count.forEach((k, v) -> {
                    System.out.println(k + v);
                });
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
