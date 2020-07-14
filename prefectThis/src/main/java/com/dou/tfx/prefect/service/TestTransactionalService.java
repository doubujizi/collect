package com.dou.tfx.prefect.service;

import com.dou.tfx.prefect.enity.User;
import com.dou.tfx.prefect.enity.User1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/5/8 17:34
 */
@Service
@Slf4j
public class TestTransactionalService {
    @Autowired
    private UserService userService;
    @Autowired
    private User1Service user1Service;

    //场景一
    //此场景外围方法没有开启事务

    //情景 外层方法没事务注解 外层方法出现异常  结果 方法A和方法B的事务均正常执行
    public void notransaction_exception_required_required() {
        User user = new User();
        user.setName("张三");
        userService.insertUser(user);
        User1 user1 = new User1();
        user1.setName("李四");
        user1Service.insertUser1(user1);
        throw new RuntimeException();
    }

    //情景 外层方法没有注解  内层方法抛出异常  结果
    public void notransaction_required_required_exception() {
        User user = new User();
        user.setName("zhangsan");
        user.setPassword("aaaa");
        userService.insertUser(user);

        User1 user1 = new User1();
        user1.setName("lisi");
        user1.setPassword("aaaa");
        user1Service.insertUser1(user1);
    }

    //结论：通过这两个方法证明了在外围方法未开启事务的情况下Propagation.REQUIRED 修饰的内部方法会新开启自己的事务，
    // 且开启的事务互相独立，互不干扰


    //场景二
    //外围开启事务

}
