package com.uat.automation.testcase.analytics.search;

import com.uat.automation.annotation.TestCaseInfo;
import com.uat.automation.testcase.TestBase;
import org.testng.annotations.Test;


/**
 * @Author Paul.Wang
 * @Date 2018/7/20
 */
public class PatentViewTest extends TestBase {

    @TestCaseInfo(date = "15:08",events = {"hello","world"})
    @Test(enabled = false)
    public void testDemo(){
        System.out.print("test demo");
        initialBrowser("chrome");
        driver.get("https://www.baidu.com");
    }
}
