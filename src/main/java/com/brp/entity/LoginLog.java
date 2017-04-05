package com.brp.entity;

import java.util.Date;

/**
 * @Author yuchuanshen
 * @Date Created by 2017/4/5
 * @Desc MyBase-com.brp.entity
 */
public class LoginLog {
    private String id;
    private Date loginTime; //登陆时间
    private String device;  //设备(电脑，手机，ipad)
    private String system; //系统
    private String browser;
    private String browserNo; //浏览器版本
    private String ipAddr; //ip地址
    private String userId; //用户id
    private String companyId; //公司id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getBrowserNo() {
        return browserNo;
    }

    public void setBrowserNo(String browserNo) {
        this.browserNo = browserNo;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
