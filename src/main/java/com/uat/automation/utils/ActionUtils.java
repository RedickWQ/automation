package com.uat.automation.utils;

import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Set;

/**
 * @Author Paul.Wang
 * @Date 2018/7/26
 */
public class ActionUtils {

    /**
     * 根据tag值，确认是切换到父窗口是其他tab页，tag=true时切换到父tab，反之切换到其他tab，适用于两个tab页的快速切换
     * @param driver
     * @param tag
     * @author wq
     * @since  2017/7/5
     */
    public static void switchWindowWithHandle(WebDriver driver, Boolean tag){
        Set<String> handles = driver.getWindowHandles();
        String current = driver.getWindowHandle();
        if(tag=true){
            handles.remove(current);
            String parentHandle = handles.iterator().next();
            driver.switchTo().window(parentHandle);
        }else {
            driver.switchTo().window(current);
        }
    }

    /**
     * close all tabs exclude current tab
     * @param driver
     * @param currentHandle
     */
    public static void closeOtherTabs(WebDriver driver,String currentHandle){
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!handle.equalsIgnoreCase(currentHandle)) {
                driver.close();
            }
        }
    }


}
