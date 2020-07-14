package com.dou.tfx.prefect.strong.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/4/17 14:39
 */
public class StarsNewProxy implements InvocationHandler {
    //代理类持有委托的对象引用
    private Object object;
    //保存sing和dance次数
    private int num;

    public StarsNewProxy(Object object) {
        this.object = object;
    }

    /**
     * @param proxy  被代理对象
     * @param method 被代理对象的某个方法
     * @param args   被代理对象某个方法接收的对象
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (!runBefore(method)) {
            return null;
        }
        Object result = method.invoke(object, args);
        runAfter(method);
        return result;
    }

    private boolean runBefore(Method method) {
        System.out.println("我是代理,拦截到请求");
        if ("dance".equals(method.getName())) {
            System.out.println("抱歉，明星脚受伤了，不能跳舞表演了。");
            return false;
        }
        return true;
    }

    private void runAfter(Method method) {
        System.out.println("我是代理，请求处理完毕");
    }
}
