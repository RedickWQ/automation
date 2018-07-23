package com.uat.automation.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Author Paul.Wang
 * @Date 2018/7/23
 */
@Data
public class ParamInfoBean extends BaseBean {
    public ParamInfoBean(){
        System.out.println("initial ParamInfoBean");
    }
    private String userName;
    private String pwd;

}
