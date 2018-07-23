package com.uat.automation.testcase.analytics.common;

import com.uat.automation.annotation.TestCaseInfo;
import com.uat.automation.handler.EnvHandler;
import com.uat.automation.testcase.TestBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

/**
 * @Author Paul.Wang
 * @Date 2018/7/23
 */
@SpringBootTest
public class LoginTest extends TestBase {
    @Autowired
    EnvHandler envHandler;

    @Test
    @TestCaseInfo(date = "15:06",events = "Logged in")
    public void login(){
        System.out.println("this is login ==============");
        System.out.println(driver);
    }
}
