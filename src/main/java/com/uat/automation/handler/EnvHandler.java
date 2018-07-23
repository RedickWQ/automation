package com.uat.automation.handler;

import com.uat.automation.config.PropertiesConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Paul.Wang
 * @Date 2018/7/23
 */
@Service
public class EnvHandler {

    private static Logger logger = LoggerFactory.getLogger(EnvHandler.class);
    @Autowired
    PropertiesConfig propertiesConfig;

    public String getWebDriver(String type){
        List<String> driverList = propertiesConfig.getDrivers();
        for (String driver:driverList) {
            if (driver.equalsIgnoreCase(type)) {
                return driver;
            }
        }
        logger.error("no such web driver");
        return null;
    }


    public boolean getIsMultiDrivers(){
        return propertiesConfig.getIsMultiDrivers();
    }
}
