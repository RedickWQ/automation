package com.uat.automation.pages.search;

import com.uat.automation.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @Author Paul.Wang
 * @Date 2018/7/23
 */
public class AdvanceSearch extends BasePage {
    @FindBy(id="username")
    public WebElement userName;

}
