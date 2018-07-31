package com.uat.automation.pages.commonPages;

import com.uat.automation.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

/**
 * @Author Paul.Wang
 * @Date 2018/7/27
 */
public class PatentsListPage extends BasePage {
    //左侧filter选项
    @FindBy(className = "filter-item")
    public List<WebElement> filterElements;


    //左侧“筛选”按钮
    @FindBy(xpath="html/body/div[1]/div/div[2]/div[1]/div[1]/div[2]/div/div/div[3]/div[1]/button")
    public WebElement filtrateButton;


    //复制检索式url
    @FindBy(xpath = ".//span[contains(text(),'复制检索式')]")
    public WebElement copyQuery;



    //功能按钮div
    @FindBy(className = "function-buttons")
    public WebElement funcButtonDiv;

    //保存Query按钮
    @FindBy(xpath = ".//*[@id='button-bar']/div[2]/div[1]/button[1]")
    public WebElement saveQuery;


    //email alert button
    @FindBy(xpath = ".//*[@id='button-bar']/div[2]/div[1]/button[2]")
    public WebElement emailAlertButton;

    //下载按钮
    @FindBy(className = "export icon-bar")
    public WebElement exportButton;

    //workspace button
    @FindBy(xpath = ".//*[@id='button-bar']/div[2]/div[1]/button[4]")
    public WebElement workspaceButton;

    //===============================保存query弹窗==========================
    //保存Query弹窗的整体div
    @FindBy(className = "save-query-dialog-body")
    public WebElement divWhole;

    //保存Query弹窗的名称div
    @FindBy(className = "item query-name")
    public WebElement nameDiv;

    //保存Query弹窗的名称input输入框
    @FindBy(xpath = "html/body/div[3]/div/div[2]/div[3]/div/div/div[2]/div/div[1]/input")
    public WebElement saveInput;


    //保存Query弹窗的检索式文本框
    @FindBy(xpath = ".//textarea[@name = 'name']")
    public WebElement textarea;


    //保存Query弹窗的提交按钮
    @FindBy(xpath = ".//button[contains(text(),'提交')]")
    public WebElement saveSubmit;

    //保存Query弹窗的取消按钮
    @FindBy(xpath = ".//button[contains(text(),'取消')]")
    public WebElement saveCancel;

    //===============================保存工作空间弹窗==========================


    //第一个工作空间
    @FindBy(xpath = "html/body/div[1]/div/div[2]/div[3]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div/div[1]/div[1]/div[1]")
    public WebElement workspaceTab;

    //第一个工作空间第一个folder
    @FindBy(xpath = "html/body/div[1]/div/div[2]/div[3]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div/div[1]/div[1]/div[2]/div/div/div/div/ul/li/div")
    public WebElement folder;


    //添加新的工作空间
    @FindBy(xpath = "html/body/div[1]/div/div[2]/div[3]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div/div[2]/span")
    public WebElement createWorkspace;


    //取消按钮
    @FindBy(xpath = ".//button[contains(text(),'取消')]")
    public WebElement createCancel;

    //保存到工作空间按钮
    @FindBy(xpath = ".//button[contains(text(),'保存到工作空间')]")
    public WebElement saveButton;

}
