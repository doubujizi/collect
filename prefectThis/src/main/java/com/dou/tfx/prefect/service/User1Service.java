package com.dou.tfx.prefect.service;

import com.dou.tfx.prefect.dao.User1Mapper;
import com.dou.tfx.prefect.enity.User;
import com.dou.tfx.prefect.enity.User1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/5/8 17:42
 */
@Service
@Slf4j
public class User1Service {
    @Autowired
    private User1Mapper user1Mapper;

    @Transactional(propagation = Propagation.REQUIRED)
    public void insertUser1(User1 user1){
        user1Mapper.insert(user1);
    }

   // @Transactional(propagation = Propagation.REQUIRED)
    public void insertUser1Exception(User1 user1){
        user1Mapper.insert(user1);
        throw new RuntimeException();
    }
}
