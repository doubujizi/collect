package com.dou.tfx.prefect.service;

import com.dou.tfx.prefect.dao.User2Mapper;
import com.dou.tfx.prefect.enity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/5/9 16:30
 */
@Service
@Slf4j
public class User2Service {
    @Autowired
    private User2Mapper user2Mapper;

    public void insetUser2(User user) {
        user2Mapper.insert(user);
        //Added this to force a roll back for testing
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }

    public void insetUser2Exception(User user) {
        user2Mapper.insert(user);
        throw new RuntimeException();
    }
}
