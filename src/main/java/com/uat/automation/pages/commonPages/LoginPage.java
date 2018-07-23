package com.uat.automation.pages.commonPages;

import com.uat.automation.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @Author Paul.Wang
 * @Date 2018/7/23
 */
public class LoginPage extends BasePage {
    //用户名输入框
    @FindBy(id="acount")
    public WebElement userName;

    //密码输入框
    @FindBy(id="password")
    public WebElement password;

    //登录按钮
    @FindBy(id="log-button")
    public WebElement login;
}
