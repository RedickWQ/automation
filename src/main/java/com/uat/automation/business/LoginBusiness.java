package com.uat.automation.business;

import com.uat.automation.bean.ParamInfoBean;
import com.uat.automation.pages.commonPages.HomePage;
import com.uat.automation.pages.commonPages.LoginPage;
import com.uat.automation.utils.SleepUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Service;

/**
 * @Author Paul.Wang
 * @Date 2018/7/24
 */
@Service
public class LoginBusiness extends BaseBusiness {
    private LoginPage loginPage;
    private HomePage homePage;


    public void login(WebDriver driver, ParamInfoBean param){
        loginPage = PageFactory.initElements(driver,LoginPage.class);
        homePage = PageFactory.initElements(driver,HomePage.class);
        driver.navigate().to(param.getUrl());
        loginPage.userName.sendKeys(param.getUserName());
        loginPage.password.sendKeys(param.getPwd());
        loginPage.login.click();
        logger.info(param.getUserName()+",welcome to PatSnap");
        SleepUtils.elementToBeClickable(driver,homePage.gbButton);
    }
}
