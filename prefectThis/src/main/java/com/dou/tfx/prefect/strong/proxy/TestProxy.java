package com.dou.tfx.prefect.strong.proxy;

/**
 * @author tianfuxian
 * @Description: 1.代理类需要和被代理类实现相同的接口，这样才能一起向上转型后实现多态
 * 2.当被代理的类需要进行扩展增多 管理会变得困难 之后对被代理类的修改 需要同时修改代理类 增加了修改成本
 * @Date: 2020/4/17 14:10
 */
public class TestProxy {
    public static void main(String[] args) {
        IStars iStars = new Stars("tfx");
        IStars iStarsProxy = new StarsProxy(iStars);
        for (int i = 0;i < 5; i++){
            iStarsProxy.sing();
        }
    }
}
