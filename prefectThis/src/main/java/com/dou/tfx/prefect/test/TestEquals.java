package com.dou.tfx.prefect.test;

import com.dou.tfx.prefect.enity.Phone;
import com.dou.tfx.prefect.enity.PhoneNoEquals;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/11/11 15:04
 */
public class TestEquals {
    public static void main(String[] args) throws Exception {
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

        int i = 0;
        try {
            i = LocalDate.now().getYear();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(i);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
        Date date = simpleDateFormat.parse("2015-11-20 00:00:00");
        System.out.println(date);   //Mon Sep 02 00:00:00 CST 2019
        System.out.println(simpleDateFormat.format(date));  //2019-09-02

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyyMMddHHmmss");//注意月份是MM
        Date date1 = simpleDateFormat1.parse("20190902000000");
        System.out.println(date1);
        String TPYDate = "20210101000000";
        DateTimeFormatter dfTPY = DateTimeFormatter.ofPattern("yyyyMMdd");
        DateTimeFormatter dfBC = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate TPYDateLocal = LocalDate.parse(TPYDate.substring(0,8), dfTPY);
        String format = dfBC.format(TPYDateLocal);
        System.out.println(format);
        String sss = "2021-01-02 00:00:00";
        System.out.println(sss.substring(0,9));


    }
}
