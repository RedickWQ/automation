package com.uat.automation.pages.commonPages;

import com.uat.automation.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * @Author Paul.Wang
 * @Date 2018/7/30
 */
public class ExportPage extends BasePage {
    //所有的导出格式
    //excel/pdf/rtf/xml/csv
    @FindBy(xpath=".//input[@name='format']")
    public List<WebElement> exportTypes;


    //格式的ul
    @FindBy(className = "select-file-format")
    public WebElement formatUl;


    //导出按钮
    @FindBy(xpath=".//input[@value='导出']")
    public WebElement exportButton;
}
