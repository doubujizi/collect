package com.dou.tfx.prefect.thread;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/8/26 15:00
 */
public class TestFoo {
    public static void main(String[] args) {
        Foo foo = new Foo();
        new Thread(()->{
            try {
                foo.first(()->{
                    System.out.println(1);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                foo.second(()->{
                    System.out.println(2);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                foo.third(()->{
                    System.out.println(3);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
