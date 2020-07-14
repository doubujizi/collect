package com.dou.tfx.prefect.strong.proxy;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/4/17 14:08
 */
public class StarsProxy implements IStars {
    private  IStars stars;
    private AtomicInteger atomicInteger = new AtomicInteger(0) ;
    public StarsProxy(IStars stars) {
        this.stars = stars;
    }


    @Override
    public void sing() {
        if(atomicInteger.get()>3){
            System.out.println("代理说 明星累了");
            return;
        }
        System.out.println("我是代理，我收到了唱歌请求");
        stars.sing();
        atomicInteger.incrementAndGet();
        System.out.println("唱歌完毕");
    }

    @Override
    public void dance() {
        if(atomicInteger.get()>3){
            System.out.println("代理说 明星累了");
            return;
        }
        System.out.println("我是代理，我收到了跳舞请求");
        stars.dance();
        System.out.println("跳舞完毕");

    }
}
