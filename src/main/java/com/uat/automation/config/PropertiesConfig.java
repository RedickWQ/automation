package com.uat.automation.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Paul.Wang
 * @Date 2018/7/20
 */

@Component
@ConfigurationProperties(prefix = "com.patsnap.uat")
@PropertySource(value = "Configuration.properties")
public class PropertiesConfig {
    public boolean isMultiDrivers;
    public List<String> drivers = new ArrayList<>();
    public Map<String,String> paramInfoMap = new HashMap<>();
    public boolean getIsMultiDrivers(){
        return isMultiDrivers;
    }
    public void setIsMultiDrivers(boolean isMultiDrivers){
        this.isMultiDrivers=isMultiDrivers;
    }
    public List<String> getDrivers() {
        return drivers;
    }
    public void setUrls(List<String> drivers) {
        this.drivers = drivers;
    }

    public Map<String,String> getParamInfoMap(){
        return paramInfoMap;
    }
    public void setParamInfoMap(Map<String,String> paramInfoMap){
        this.paramInfoMap = paramInfoMap;
    }
}
