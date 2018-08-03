package com.uat.automation.testcase.analytics.common;

import com.uat.automation.business.HomeBusiness;
import com.uat.automation.business.BaseBusiness;
import com.uat.automation.business.LoginBusiness;
import com.uat.automation.business.PatentsListBusiness;
import com.uat.automation.exception.NotFindElementException;
import com.uat.automation.testcase.TestBase;
import com.uat.automation.utils.ActionUtils;
import com.uat.automation.utils.SleepUtils;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
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
    @Autowired
    PatentsListBusiness patentsListBusiness;
    private String homePageHandle;

    @Test(priority = 1,description = "Logged In")
    public void login(){
        initial("chrome");
        loginBusiness.login(driver,param);
        homePageHandle = driver.getWindowHandle();
    }

    @Test(priority = 2,description = "Clicked Learn Video")
    public void clickLearnVideo(){
        homeBusiness.clickLearnVideo(driver);
        driver.switchTo().window(homePageHandle);
    }


    @Test(priority = 3,description = "Searched Patents, Viewed Patent Results")
    public void searchPatent(){
        homeBusiness.searchPatent(driver,param);
    }

    @AfterClass
    public void afterClass(){
        ActionUtils.closeAllTabs(driver);
    }



}
