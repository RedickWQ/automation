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

    @Test(enabled = false,priority = 2,description = "Clicked Learn Video")
    public void clickLearnVideo() throws Exception{
        homeBusiness.clickLearnVideo(driver);
        driver.switchTo().window(homePageHandle);
    }


    @Test(priority = 3,description = "Searched Patents, Viewed Patent Results")
    public void searchPatent(){
        homeBusiness.searchPatent(driver,param);
    }

    @Test(enabled = false,priority = 4,description = "Applied Patent Filter")
    public void applyFilter(){
        try {
            List<String> filters = new ArrayList<>();
            filters.add("IPC分类");
            filters.add("CPC分类");
            param.setFilters(filters);
            patentsListBusiness.doFilters(driver,param);
            SleepUtils.threadSleep(5000);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test(enabled = false,priority = 5,description = "Copied Patent Query With Filters")
    public void copyQuery(){
        patentsListBusiness.copyQuery(driver);
        SleepUtils.threadSleep(500);
    }


    @Test(enabled = false,priority = 6,description = "Saved Query")
    public void saveQuery(){
        patentsListBusiness.saveQuery(driver);
    }


    @Test(enabled = false,priority = 7,description = "Exported Patent Results")
    public void exportPatent(){
        param.setExportType("Excel");
        patentsListBusiness.exportPatent(driver,param);
    }


    @Test(enabled = false,priority = 8,description = "Created Workspace, Created Workspace Folder,Saved To Workspace")
    public void createWorkspace(){
        patentsListBusiness.createWorkspace(driver);
    }

    @Test(priority = 8,description = "Saved To Workspace")
    public void saveToWorkspace(){
        patentsListBusiness.saveToWorkspace(driver);
    }

}
