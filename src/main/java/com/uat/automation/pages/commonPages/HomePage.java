package com.uat.automation.pages.commonPages;

import com.uat.automation.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * @Author Paul.Wang
 * @Date 2018/7/25
 */
public class HomePage extends BasePage {
    //全球数据库按钮
    @FindBy(xpath = ".//*[@id='content-form']/div[1]/span[4]")
    public WebElement gbButton;

    //learning video
    @FindBy(xpath = "html/body/div[1]/div[4]/div[3]/div[2]/div[1]/a")
    public WebElement learnVideo;


    //search bar
    @FindBy(xpath = ".//*[@id='content-form']/div[2]/div/div/div[1]/input[1]")
    public WebElement searchBar;


    //search button
    @FindBy(xpath = ".//*[@id='content-form']/button")
    public WebElement searchButton;

    //homepage上方菜单键
    @FindBy(xpath = "html/body/div[1]/div[1]/div/nav/ul/li")
    public List<WebElement> menuItems;
}
