package com.dou.tfx.prefect.algorithm;

import org.springframework.boot.web.servlet.FilterRegistrationBean;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/10/30 18:23
 */
public class TestQ {
    int upTime=5;
    //1 2 电梯
    int stopTimeA = 50;
    int waitTimeA = 150;
    //3 电梯
    int stopTimeB = 30;
    int waitTimeB = 100;
    public static void main(String[] args) {
        TestQ q = new TestQ();
        for (int i=3; i<=15;i++){
            System.out.println("当前层数"+i);
            q.up(i);
        }

    }

    public  void up(int n){

        if (n % 2 == 1){
            //奇数
            int spentTime1= upTime*(n-1)+waitTimeA+((n-1)/2-1)*stopTimeA;
            int spentTime3=upTime*(n-1)+waitTimeB+(n-2)*stopTimeB;
            if(spentTime1>spentTime3){
                System.out.println("坐电梯3时间短"+"时间"+spentTime3);
            }else {
                System.out.println("坐电梯1时间短"+"时间"+spentTime1);
            }
        }else {
            //偶数
            int spentTime2= upTime*(n-1)+waitTimeA+((n-2)/2)*stopTimeA;
            int spentTime3=upTime*(n-1)+waitTimeB+(n-2)*stopTimeB;
            if(spentTime2>spentTime3){
                System.out.println("坐电梯3时间短"+"时间"+spentTime3);
            }else {
                System.out.println("坐电梯2时间短"+"时间"+spentTime2);
            }
        }
    }
}
