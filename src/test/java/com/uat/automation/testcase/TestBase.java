package com.uat.automation.testcase;

import com.uat.automation.bean.ParamInfoBean;
import com.uat.automation.handler.EnvHandler;
import com.uat.automation.utils.CommonUtils;
import com.uat.automation.utils.SpringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;


/**
 * @Author Paul.Wang
 * @Date 2018/7/20
 */
public class TestBase extends AbstractTestNGSpringContextTests {
    @Autowired
    EnvHandler envHandler;

    public WebDriver driver=null;
    public String type = null;
    public Logger log = LoggerFactory.getLogger(TestBase.class.getName());
    public ParamInfoBean param;

    /**
     * 根据testNG.XML配置文件传入driverType的值，用于方法中启动不同的浏览器
     * @param driverType
     * 根据传入不同的值，启动不同的浏览器
     */
    public void initial(String driverType) {
        //详细介绍：https://www.oschina.net/translate/using-headless-mode-in-java-se
        //关闭Headless模式
        System.setProperty("java.awt.headless", "false");

        //获取参数的bean
        param = (ParamInfoBean) SpringUtils.getBean("paramInfoBean");
//        //判断执行多浏览器兼容测试开关是否开启
//        if (envHandler.getIsMultiDrivers() == )
        log.info("初始化浏览器");
        type=driverType;
        switch (driverType) {
            case "firefox":
                //todo how to fit ff 47
//                System.setProperty("webdriver.gecko.driver", CommonUtils.getRealpath()+"resources/geckodriver.exe");
//                System.setProperty("webdriver.gecko.driver","E:/software/firefox/firefox.exe");
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
