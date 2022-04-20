package com.dou.tfx.prefect.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2021/7/5 4:16 下午
 */
public class TestDriver {


    public static void main(String[] args) throws Exception {
        Configuration.holdBrowserOpen = true;
        WebDriver driver = new SafariDriver();
        try {

            WebDriverRunner.setWebDriver(driver);
            JavascriptExecutor j = (JavascriptExecutor) driver;
            j.executeScript("alert('hellow,world!')");
            Selenide.open("http://eservice.ciitc.com.cn/ePolicy/download");
            Configuration.holdBrowserOpen = true;
            Thread.sleep(100000);
        } finally {
            driver.quit();
        }


    }




}
