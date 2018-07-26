package com.uat.automation.bean;

import lombok.Data;

/**
 * @Author Paul.Wang
 * @Date 2018/7/23
 */
public class ParamInfoBean extends BaseBean {
    public ParamInfoBean(){}


    private String userName;
    private String pwd;
    private String url;
    private String pn;



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }
}
