package com.dou.tfx.prefect.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2021/3/31 8:35 下午
 */
public class TestLuoMa {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        int sum = 0;
        int t = 0;
        Map<String,String> hashMap = new HashMap<>();
        hashMap.put("I","0");
        hashMap.put("V","1");
        hashMap.put("X","2");
        hashMap.put("L","3");
        hashMap.put("C","4");
        hashMap.put("D","5");
        hashMap.put("M","6");
        for (int i=0;i<stringList.size();i++){
            if("I".equals(stringList.get(i))){
                t=1;
            }
            if("V".equals(stringList.get(i))){
                t=5;
            }
            if("X".equals(stringList.get(i))){
                t=10;
            }
            if("L".equals(stringList.get(i))){
                t=50;
            }
            if("C".equals(stringList.get(i))){
                t=100;
            }
            if("D".equals(stringList.get(i))){
                t=500;
            }
            if("M".equals(stringList.get(i))){
                t=1000;
            }
            if(hashMap.get(stringList.get(i)).compareTo(hashMap.get(stringList.get(i+1)))>0){
                sum=t+sum;
            }else {
                sum=sum-t;
            }
        }

    }
}
