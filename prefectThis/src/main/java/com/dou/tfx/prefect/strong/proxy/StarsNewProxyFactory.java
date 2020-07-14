package com.dou.tfx.prefect.strong.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/4/17 14:49
 */
public class StarsNewProxyFactory {
    //构建工厂类，客户类调用此方法获得代理对象
    //对于客户类而言，代理类对象和委托类对象是一样的，不需要知道具体返回的类型
    public static IStars getInstance(String name) {
        IStars stars = new Stars(name);
        InvocationHandler handler = new StarsNewProxy(stars);
        IStars proxy;
        //一个ClassLoader对象，定义了由哪个ClassLoader对象来对生成的代理对象进行加载
        //一个Interface对象的数组，表示的是我将要给我需要代理的对象提供一组什么接口，如果我提供了一组接口给它，那么这个代理对象就宣称实现了该接口，这样就能调用这组接口中的方法
        //一个InvocationHandler对象，表示的是当我这个动态代理对象在调用方法的时候，会关联到哪一个InvocationHandler对象上
        proxy = (IStars) Proxy.newProxyInstance(stars.getClass().getClassLoader(),
                stars.getClass().getInterfaces(), handler);
        return proxy;
    }
}
