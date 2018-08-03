package com.uat.automation.business;

import com.uat.automation.bean.ParamInfoBean;
import com.uat.automation.exception.TypeErrorException;
import com.uat.automation.pages.workspace.WorkspacePage;
import com.uat.automation.utils.SleepUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Paul.Wang
 * @Date 2018/8/1
 */
@Service
public class WorkSpaceBusiness extends BaseBusiness {
    private WorkspacePage workspacePage;

    /**
     * 根据工作空间名称点击对应的workspace
     * @param driver
     * @param workspaceName
     * @throws TypeErrorException
     */
    public void viewWorkspace(WebDriver driver , String workspaceName) throws TypeErrorException{
        workspacePage = PageFactory.initElements(driver,WorkspacePage.class);
        List<WebElement> eles = workspacePage.cards;
        Map<String, WebElement> nameElementMap = new HashMap<>();
        for (WebElement ele : eles) {
            nameElementMap.put(ele.getText(),ele);
        }
        int count = 0 ;
        for (Map.Entry<String,WebElement> entry : nameElementMap.entrySet()){
            count ++;
            if (entry.getKey().contains(workspaceName)){
                entry.getValue().click();
                logger.info("succeed to view workspace: "+workspaceName);
            }
            if (count > nameElementMap.size()){
                throw new TypeErrorException(workspaceName+", no such workspace");
            }
        }
    }


    /**
     * 分享工作空间（依赖于已经进入了对应的工作空间）
     * @param driver
     */
    public void shareWorkspace(WebDriver driver, ParamInfoBean bean){
        workspacePage = PageFactory.initElements(driver,WorkspacePage.class);
        workspacePage.shareButton.click();
        SleepUtils.threadSleep(3000);
        workspacePage.emailInput.sendKeys(bean.getShareToAccount());
        workspacePage.addButton.click();
        SleepUtils.threadSleep(1000);
        workspacePage.submitButton.click();
        logger.info("share to "+bean.getShareToAccount()+" successfully");
    }
}
