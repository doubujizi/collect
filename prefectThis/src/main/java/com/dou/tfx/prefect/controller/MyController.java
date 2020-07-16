package com.dou.tfx.prefect.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/7/16 16:51
 */
@RestController
@RequestMapping("/api")
public class MyController {

    @GetMapping("/hello")
    public String getHello() throws InterruptedException {
        Thread.sleep(1000);
        return "Hello";
    }
}
