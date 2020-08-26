package com.dou.tfx.prefect.service;

import com.dou.tfx.prefect.dao.User2Mapper;
import com.dou.tfx.prefect.dao.UserMapper;
import com.dou.tfx.prefect.enity.User;
import com.dou.tfx.prefect.enity.UserTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/5/9 16:09
 */
@Service
@Slf4j
public class TestDataSourceService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private User2Mapper user2Mapper;

    @Autowired
    private UserService userService;
    @Autowired
    private User2Service user2Service;

    public void aaa() {
        User user = user2Mapper.selectByPrimaryKey(2L);
        User user1 = userMapper.selectByPrimaryKey(2L);
        System.out.println(user);
        System.out.println(user1);
    }

    public void ccc(){
        UserTest userTest = userMapper.selectByPrimaryKey1();
        System.out.println(userTest);
        System.out.println(111);
    }

    @Transactional
    public void bbb() {
        User user = new User();
        user.setName("wangwu");
        user.setPassword("aaaa");
        userService.insertUser(user);

        User user2 = new User();
        user2.setName("wangwu2");
        user2.setPassword("aaaa");
        user2Service.insetUser2(user2);
    }
}
