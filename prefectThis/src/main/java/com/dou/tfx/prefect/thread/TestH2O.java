package com.dou.tfx.prefect.thread;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/8/25 10:47
 */
public class TestH2O {
    public static void main(String[] args) {


        H2O h2O = new H2O();

        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    h2O.oxygen(() -> {
                        System.out.println("O");
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();
        new Thread(() -> {
            for (int j = 0; j < 3; j++) {
                try {
                    h2O.hydrogen(() -> {
                        System.out.println("H");
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int k = 0; k < 3; k++) {
                try {
                    h2O.hydrogen(() -> {
                        System.out.println("H");
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }
}
