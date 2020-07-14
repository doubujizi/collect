package com.dou.tfx.prefect.strong.proxy;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/4/17 14:05
 */
public class Stars implements IStars {
    private String name;

    public Stars(String name) {
        this.name = name;
    }

    @Override
    public void sing() {
        System.out.println(getName() + "唱了一支歌");
    }

    @Override
    public void dance() {
        System.out.println(getName() + "跳了一支舞");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
