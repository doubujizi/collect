package com.dou.tfx.prefect.strong.proxy.cglib;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/4/17 15:20
 */
public class Programmer {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Setting Name");
        this.name = name;
    }
    public void code(){
        System.out.println(name + " is writing bugs.");
    }
}
