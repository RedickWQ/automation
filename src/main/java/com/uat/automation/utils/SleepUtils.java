package com.uat.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * @Author Paul.Wang
 * @Date 2018/7/24
 */
public class SleepUtils {
    /**
     * wait until target element to be clickable in 10s, if out of time , throw exception
     * @param driver    WebDriver
     * @param element   target
     */
    public static void elementToBeClickable(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    /**
     * thread to sleep
     * @param millisecond 毫秒
     */
    public static void threadSleep(int millisecond){
        try {
            Thread.sleep(millisecond);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
