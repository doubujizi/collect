package com.dou.tfx.prefect.test;

import com.dou.tfx.prefect.enity.Phone;
import com.dou.tfx.prefect.enity.User;
import com.dou.tfx.prefect.enity.User1;
import org.springframework.beans.BeanUtils;

import javax.servlet.annotation.WebFilter;
import java.lang.reflect.InvocationTargetException;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/7/15 16:50
 */
public class TestSpringBeanUtils {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Phone phone = new Phone(2L,"zhangsan","111");
        //下面只是用于单独测试
        User user = new User(2L,"zhangshan","aaa",phone);
        User1 user1 = new User1();
        BeanUtils.copyProperties(user,user1);
        user1.setPhone(new Phone(3L,"lisi","2222"));
        System.out.println("user:"+user);
        System.out.println("user1: "+user1);
    }
}
