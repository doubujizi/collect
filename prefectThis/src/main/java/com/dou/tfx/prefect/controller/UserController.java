package com.dou.tfx.prefect.controller;

import com.dou.tfx.prefect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/4/28 14:13
 */
@RestController
@RequestMapping("/all/user")
public class UserController {
    @Autowired
    private UserService userService;
    public void aaa(){
        System.out.println(1111);
    }
}
