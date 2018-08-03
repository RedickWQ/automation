package com.uat.automation.testcase.analytics.workspace;

import com.uat.automation.business.HomeBusiness;
import com.uat.automation.business.LoginBusiness;
import com.uat.automation.business.WorkSpaceBusiness;
import com.uat.automation.exception.TypeErrorException;
import com.uat.automation.testcase.TestBase;
import com.uat.automation.utils.SleepUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

import java.lang.reflect.Type;

/**
 * @Author Paul.Wang
 * @Date 2018/8/1
 */
@SpringBootTest
public class WorkspaceTest extends TestBase {

    @Autowired
    HomeBusiness homeBusiness;
    @Autowired
    LoginBusiness loginBusiness;
    @Autowired
    WorkSpaceBusiness workSpaceBusiness;

    @Test(priority = 1,description = "Logged In")
    public void login(){
        initial("chrome");
        loginBusiness.login(driver,param);
    }

    @Test(priority = 2,description = "Viewed Workspace Dashboard, Viewed Workspace")
    public void viewWorkspace(){
        try {
            homeBusiness.chooseMenuItem(driver,"工作空间");
            workSpaceBusiness.viewWorkspace(driver,"automation");
            SleepUtils.threadSleep(2000);
        }catch (TypeErrorException e) {
            e.printStackTrace();
        }
    }


    @Test(priority = 3,description = "Shared Workspace")
    public void shareWorkspace(){
        workSpaceBusiness.shareWorkspace(driver,param);
    }
}
