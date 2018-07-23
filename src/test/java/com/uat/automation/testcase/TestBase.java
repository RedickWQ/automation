package com.uat.automation.testcase;

import com.uat.automation.utils.CommonUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;


/**
 * @Author Paul.Wang
 * @Date 2018/7/20
 */
public class TestBase extends AbstractTestNGSpringContextTests {
    public WebDriver driver=null;
    public String type = null;
    public Logger log = LoggerFactory.getLogger(TestBase.class.getName());

    /**
     * 根据testNG.XML配置文件传入driverType的值，用于方法中启动不同的浏览器
     * @param driverType
     * 根据传入不同的值，启动不同的浏览器
     */
    public void initialBrowser(String driverType) {
        System.out.println("初始化浏览器");
        type=driverType;
        switch (driverType) {
            case "firefox":
                driver=new FirefoxDriver();
                driver.manage().window().maximize();
                log.info("启动fireFox浏览器");
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver",CommonUtils.getRealpath()+"resources/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                log.info("启动chrome浏览器");
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver",CommonUtils.getRealpath()+"resources/iedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                log.info("启动IE浏览器");
                break;
            default:
                break;
        }
    }
}
