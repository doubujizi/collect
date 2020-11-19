package com.dou.tfx.prefect.test;

import com.dou.tfx.prefect.enity.Phone;
import com.dou.tfx.prefect.enity.PhoneNoEquals;

import java.util.HashMap;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/11/11 15:04
 */
public class TestEquals {
    public static void main(String[] args) {
        String aaa = new String("aaa");
        String bbb = new String("aaa");
        System.out.println(aaa.equals(bbb));
        Phone phone = new Phone();
        Phone phone2 = new Phone();
        System.out.println(phone.equals(phone2));
        PhoneNoEquals phoneNoEquals = new PhoneNoEquals();
        PhoneNoEquals phoneNoEquals1 = new PhoneNoEquals();
        System.out.println(phoneNoEquals.equals(phoneNoEquals1));
        HashMap<String,Integer> hashMap = new HashMap<>();
    }
}
