package com.dou.tfx.prefect.strong.proxy;

/**
 * @author tianfuxian
 * @Description: JDK动态代理时实现了InvocationHandler接口重写invoke方法
 * 动态代理跟静态代理最大的不同便是生成代理类的时期不同，静态代理是在编译期，而动态代理则是在运行时根据委托类信息动态生成
 * @Date: 2020/4/17 14:58
 */
public class TestNewProxy {
    public static void main(String[] args) {
        IStars proxy = StarsNewProxyFactory.getInstance("tfx");
        proxy.dance();
        proxy.sing();
    }
}
