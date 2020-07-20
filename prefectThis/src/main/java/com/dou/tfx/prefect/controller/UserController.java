package com.dou.tfx.prefect.controller;

import com.dou.tfx.prefect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/4/28 14:13
 */
@RestController
@RequestMapping("/all/user")
//@Validated
public class UserController {
    @Autowired
    private UserService userService;

    public void aaa() {
        System.out.println(1111);
    }

    @PostMapping("/testValid")
    public String testValid(@Valid @NotBlank Integer number) {
        return "hello";
    }
}
