package com.dou.tfx.prefect.controller;

import com.dou.tfx.prefect.service.TestSpringSingleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/11/18 11:32
 */
@RestController
@RequestMapping("/test/spring2")
public class TestSpringSingle2 {
    @Autowired
    private TestSpringSingleService testSpringSingleService;
    @RequestMapping("/c")
    public void testC(){
        testSpringSingleService.testA();
    }
    @RequestMapping("/d")
    public void testD(){
        testSpringSingleService.testB();
    }
}
