package com.uat.automation.bean;

import lombok.Data;

import java.util.List;

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
    //专利搜索的filter
    private List<String> filters;
    private String exportType;
    //分享给对应的账户
    private String shareToAccount;


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

    public List<String> getFilters() {
        return filters;
    }

    public void setFilters(List<String> filters) {
        this.filters = filters;
    }

    public String getExportType() {
        return exportType;
    }

    public void setExportType(String exportType) {
        this.exportType = exportType;
    }

    public String getShareToAccount() {
        return shareToAccount;
    }

    public void setShareToAccount(String shareToAccount) {
        this.shareToAccount = shareToAccount;
    }
}
