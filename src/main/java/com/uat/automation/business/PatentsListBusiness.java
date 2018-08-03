package com.uat.automation.business;


import com.uat.automation.bean.ParamInfoBean;
import com.uat.automation.exception.NotFindElementException;
import com.uat.automation.pages.commonPages.ExportPage;
import com.uat.automation.pages.commonPages.PatentsListPage;
import com.uat.automation.utils.ActionUtils;
import com.uat.automation.utils.RobotUtils;
import com.uat.automation.utils.SleepUtils;
import org.openqa.grid.web.servlet.LifecycleServlet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Service;
import org.springframework.test.context.web.WebDelegatingSmartContextLoader;

import java.util.*;

/**
 * @Author Paul.Wang
 * @Date 2018/7/27
 */
@Service
public class PatentsListBusiness extends BaseBusiness {
    private PatentsListPage patentsListPage;
    private ExportPage exportPage;

    /**
     * 检索
     * @param driver
     * @param bean 包含对应的filter信息
     * @throws Exception
     */
    public void doFilters(WebDriver driver, ParamInfoBean bean) throws Exception {
        patentsListPage = PageFactory.initElements(driver, PatentsListPage.class);
        Thread.sleep(3000);
        List<WebElement> filtersList = patentsListPage.filterElements;
        Map<WebElement, String> filterNameMap = new HashMap();
        if (!filtersList.isEmpty()) {
            for (WebElement ele : filtersList) {
                String eleName = ele.getText();
                filterNameMap.put(ele, eleName);
            }
        } else {
            throw new NotFindElementException("not get filter elements");
        }
        List<String> filters = bean.getFilters();
        if (filters.size() != 0) {
            for (Map.Entry<WebElement, String> entry : filterNameMap.entrySet()) {
                for (String filter : filters) {
                    if (filter.equalsIgnoreCase(entry.getValue())) {
                        entry.getKey().click();
                        Thread.sleep(1000);
                        List<WebElement> checkBoxs = entry.getKey().findElements(By.xpath(".//input[@type='checkbox']"));
                        assertListIsEmpty(checkBoxs);
                        checkBoxs.get(0).click();
                        logger.info("select the filter : "+entry.getValue());
                    }
                }
            }
        }
        SleepUtils.threadSleep(500);
        patentsListPage.filtrateButton.click();
        logger.info("do filter");

    }

    /**
     * copy query
     * @param driver
     */
    public void copyQuery(WebDriver driver){
        patentsListPage = PageFactory.initElements(driver, PatentsListPage.class);
        patentsListPage.copyQuery.click();
    }


    /**
     * save query
     * @param driver
     */
    public void saveQuery(WebDriver driver){
        patentsListPage = PageFactory.initElements(driver, PatentsListPage.class);
        patentsListPage.saveQuery.click();
        SleepUtils.elementToBeClickable(driver,patentsListPage.saveCancel);
        patentsListPage.divWhole.findElement(By.tagName("input")).sendKeys(String.valueOf(System.currentTimeMillis()));
        patentsListPage.saveSubmit.click();
    }


    /**
     * export patent
     * @param driver
     */
    public void exportPatent(WebDriver driver, ParamInfoBean bean ){
        patentsListPage = PageFactory.initElements(driver, PatentsListPage.class);
        exportPage = PageFactory.initElements(driver, ExportPage.class);
        patentsListPage.funcButtonDiv.findElements(By.tagName("button")).get(2).click();
        SleepUtils.threadSleep(2000);
//        String type = bean.getExportType();
//        List<WebElement> eles = exportPage.formatUl.findElements(By.tagName("li"));
//        switch (type.toUpperCase()){
//            case "EXCEL":
//                logger.info("export excel");
//            case "PDF":
//                eles.get(1).click();
//                logger.info("export PDF");
//            case "RTF":
//                eles.get(2).click();
//                logger.info("export RTF");
//            case "XML":
//                eles.get(3).click();
//                logger.info("export XML");
//            case "CSV":
//                eles.get(4).click();
//                logger.info("export CSV");
//            default:
//                logger.error("your type is wrong");
//        }
        ActionUtils.switchWindowWithHandle(driver,false);
        exportPage.exportButton.click();
        ActionUtils.switchWindowWithHandle(driver,true);
    }


    /**
     * create work space
     * @param driver
     */
    public void createWorkspace(WebDriver driver){
        patentsListPage = PageFactory.initElements(driver, PatentsListPage.class);
        SleepUtils.threadSleep(1000);
        String folderName = String.valueOf(System.currentTimeMillis());
        patentsListPage.workspaceButton.click();
        SleepUtils.threadSleep(1000);
        patentsListPage.createWorkspace.click();
        RobotUtils.setAndctrlVClipboardData(folderName);
        RobotUtils.pressEnter();
        logger.info("created new workspace : "+folderName);
        //close tab
        patentsListPage.saveButton.click();

    }

    /**
     * save patent to work space
     * @param driver
     */
    public void saveToWorkspace(WebDriver driver){
        patentsListPage = PageFactory.initElements(driver, PatentsListPage.class);
        SleepUtils.threadSleep(1000);
        patentsListPage.funcButtonDiv.findElements(By.tagName("button")).get(3).click();
//        patentsListPage.workspaceButton.click();
        SleepUtils.threadSleep(500);
        patentsListPage.workspaceTab.click();
        patentsListPage.folder.click();
        patentsListPage.saveButton.click();
        logger.info("save to workspace successfully");
    }
}
