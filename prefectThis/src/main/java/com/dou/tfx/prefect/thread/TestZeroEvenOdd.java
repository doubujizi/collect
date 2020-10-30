package com.dou.tfx.prefect.thread;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/10/29 15:39
 */
public class TestZeroEvenOdd {
    public static void main(String[] args) {
        int n = 2;
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);
        int i = 1;
        i=i++;
        int j = i++;
        int k= i+ (++i *i++);
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
    }
}
