package com.uat.automation.business;

import com.uat.automation.bean.ParamInfoBean;
import com.uat.automation.exception.TypeErrorException;
import com.uat.automation.pages.commonPages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Service;
import sun.reflect.annotation.ExceptionProxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Paul.Wang
 * @Date 2018/7/26
 */
@Service
public class HomeBusiness extends BaseBusiness {
    private HomePage homePage;


    /**
     * 点击学习视频
     * @param driver
     */
    public void clickLearnVideo(WebDriver driver){
        homePage = PageFactory.initElements(driver,HomePage.class);
        logger.info("click learn video");
        homePage.learnVideo.click();
    }


    /**
     * 查询专利
     * @param driver
     * @param bean
     */
    public void searchPatent(WebDriver driver, ParamInfoBean bean) {
        homePage = PageFactory.initElements(driver,HomePage.class);
        logger.info("search patent by pn："+bean.getPn());
        homePage.searchBar.sendKeys(bean.getPn());
        homePage.searchButton.click();
    }


    /**
     * 点击上方菜单键，进入不同的功能
     * @param driver
     * @param type
     */
    public void chooseMenuItem(WebDriver driver, String type) throws TypeErrorException{
        homePage = PageFactory.initElements(driver,HomePage.class);
        List<WebElement> eles = homePage.menuItems;
        Map<String,WebElement> nameElementMap = new HashMap<>();
        for (WebElement ele : eles) {
            nameElementMap.put(ele.getText(),ele);
        }
        if (nameElementMap.containsKey(type)){
            nameElementMap.get(type).click();
        }else {
            throw new TypeErrorException(type + " is error");
        }
    }

}
