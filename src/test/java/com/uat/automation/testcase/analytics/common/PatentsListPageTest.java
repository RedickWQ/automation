package com.uat.automation.testcase.analytics.common;

import com.uat.automation.business.HomeBusiness;
import com.uat.automation.business.LoginBusiness;
import com.uat.automation.business.PatentsListBusiness;
import com.uat.automation.pages.commonPages.PatentsListPage;
import com.uat.automation.testcase.TestBase;
import com.uat.automation.utils.ActionUtils;
import com.uat.automation.utils.RobotUtils;
import com.uat.automation.utils.SleepUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Paul.Wang
 * @Date 2018/7/27
 */
@SpringBootTest
public class PatentsListPageTest extends TestBase {
    @Autowired
    PatentsListBusiness patentsListBusiness;
    @Autowired
    LoginBusiness loginBusiness;
    @Autowired
    HomeBusiness homeBusiness;

    @Test(priority = 1,description = "Logged In")
    public void login(){
        initial("chrome");
        loginBusiness.login(driver,param);
    }


    @Test(priority = 2,description = "Searched Patents, Viewed Patent Results")
    public void searchPatent(){
        homeBusiness.searchPatent(driver,param);
    }


    @Test(priority = 3,description = "Applied Patent Filter")
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

    @Test(priority = 4,description = "Copied Patent Query With Filters")
    public void copyQuery(){
        patentsListBusiness.copyQuery(driver);
        SleepUtils.threadSleep(500);
    }


    @Test(priority = 5,description = "Saved Query")
    public void saveQuery(){
        patentsListBusiness.saveQuery(driver);
    }


    @Test(priority = 6,description = "Exported Patent Results")
    public void exportPatent(){
        param.setExportType("Excel");
        patentsListBusiness.exportPatent(driver,param);
    }


    @Test(priority = 7,description = "Created Workspace, Created Workspace Folder")
    public void createWorkspace(){
        patentsListBusiness.createWorkspace(driver);
    }

    @Test(priority = 8,description = "Saved To Workspace")
    public void saveToWorkspace(){
        patentsListBusiness.saveToWorkspace(driver);
    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
