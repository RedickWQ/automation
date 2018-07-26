package com.uat.automation.business;

import com.uat.automation.bean.ParamInfoBean;
import com.uat.automation.pages.commonPages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Service;

/**
 * @Author Paul.Wang
 * @Date 2018/7/26
 */
@Service
public class HomeBusiness extends BaseBusiness {
    private HomePage homePage;

    public void clickLearnVideo(WebDriver driver){
        homePage = PageFactory.initElements(driver,HomePage.class);
        logger.info("click learn video");
        homePage.learnVideo.click();
    }


    public void searchPatent(WebDriver driver, ParamInfoBean bean) {
        homePage = PageFactory.initElements(driver,HomePage.class);
        logger.info("search patent by pn："+bean.getPn());
        homePage.searchBar.sendKeys(bean.getPn());
        homePage.searchButton.click();
    }
}
