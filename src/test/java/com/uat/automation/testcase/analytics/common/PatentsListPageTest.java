package com.uat.automation.testcase.analytics.common;

import com.uat.automation.business.HomeBusiness;
import com.uat.automation.business.LoginBusiness;
import com.uat.automation.testcase.TestBase;
import com.uat.automation.utils.RobotUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

/**
 * @Author Paul.Wang
 * @Date 2018/7/27
 */
@SpringBootTest
public class PatentsListPageTest extends TestBase {
    @Autowired
    LoginBusiness loginBusiness;
    @Autowired
    HomeBusiness homeBusiness;


    @Test
    public void test(){
        System.setProperty("java.awt.headless", "false");
        RobotUtils.setAndctrlVClipboardData("test");
    }


}
