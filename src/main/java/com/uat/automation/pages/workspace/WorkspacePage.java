package com.uat.automation.pages.workspace;

import com.uat.automation.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * @Author Paul.Wang
 * @Date 2018/8/1
 */
public class WorkspacePage extends BasePage {
    //工作空间cards
    @FindBy(className = "workspace-list__card")
    public List<WebElement> cards;


    //分享按钮
    @FindBy(xpath = ".//span[contains(text(),'分享')]")
    public WebElement shareButton;


    //share弹窗中的input
    @FindBy(className = "invisible-input")
    public WebElement emailInput;


    //share弹窗中的添加按钮
    @FindBy(xpath = ".//button[contains(text(),'添加')]")
    public WebElement addButton;

    //share弹窗中的提交按钮
    @FindBy(xpath = ".//button[contains(text(),'提交')]")
    public WebElement submitButton;

}
