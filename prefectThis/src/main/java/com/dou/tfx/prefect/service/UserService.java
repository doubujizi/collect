package com.dou.tfx.prefect.service;

import com.dou.tfx.prefect.dao.UserMapper;
import com.dou.tfx.prefect.enity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/4/28 14:11
 */
@Service
@Slf4j
public class UserService {
    @Autowired
    private UserMapper userMapper;


    //@Transactional(propagation = Propagation.REQUIRED)
    public void insertUser(User user) {
        userMapper.insert(user);
    }
}
