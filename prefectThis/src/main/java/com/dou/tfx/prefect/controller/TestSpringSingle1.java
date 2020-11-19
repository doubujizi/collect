package com.dou.tfx.prefect.controller;

import com.dou.tfx.prefect.service.TestSpringSingleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/11/18 11:22
 */
@RestController
@RequestMapping("/test/spring")
public class TestSpringSingle1 {
    @Autowired
    private TestSpringSingleService testSpringSingleService;
    @RequestMapping("/a")
    public void testA(){
        testSpringSingleService.testA();
    }
    @RequestMapping("/b")
    public void testB(){
        testSpringSingleService.testA();
    }
}
