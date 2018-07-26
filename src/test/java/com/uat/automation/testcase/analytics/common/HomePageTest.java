package com.uat.automation.testcase.analytics.common;

import com.uat.automation.business.HomeBusiness;
import com.uat.automation.business.BaseBusiness;
import com.uat.automation.business.LoginBusiness;
import com.uat.automation.testcase.TestBase;
import com.uat.automation.utils.ActionUtils;
import com.uat.automation.utils.SleepUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

import java.util.Set;

/**
 * @Author Paul.Wang
 * @Date 2018/7/23
 */
@SpringBootTest
public class HomePageTest extends TestBase {
    @Autowired
    LoginBusiness loginBusiness;
    @Autowired
    HomeBusiness homeBusiness;
    private String homePageHandle;

    @Test(priority = 1,description = "Logged In")
    public void login(){
        initial("chrome");
        loginBusiness.login(driver,param);
        homePageHandle = driver.getWindowHandle();
    }

    @Test(priority = 2,description = "Clicked Learn Video")
    public void clickLearnVideo() throws Exception{

        homeBusiness.clickLearnVideo(driver);
        Set<String> handles = driver.getWindowHandles();
        Thread.sleep(5000);
        ActionUtils.closeOtherTabs(driver,homePageHandle);
//        driver.close();
    }


    @Test(priority = 3,description = "Searched Patents, Viewed Patent Results")
    public void searchPatent(){
        homeBusiness.searchPatent(driver,param);
        SleepUtils.sleepBySec(driver,5);
//        driver.close();
    }





}
