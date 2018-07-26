package com.uat.automation.handler;

import com.uat.automation.bean.ParamInfoBean;
import com.uat.automation.config.PropertiesConfig;
import com.uat.automation.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @Author Paul.Wang
 * @Date 2018/7/23
 */
@Configuration
public class RegisterHandler {
    @Autowired
    PropertiesConfig propertiesConfig;

    @Bean(name = "paramInfoBean")
    public ParamInfoBean getParamInfoBean(){
        Map<String,String> beanMap = propertiesConfig.getParamInfo();
        return CommonUtils.map2Bean(beanMap,ParamInfoBean.class);
    }
}
