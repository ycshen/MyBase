package com.brp.model;
/**
 * 
 * @author luoning
 * @date 2016年3月21日
 */
public class LoginUserInfo {
	//登陆员工ID
	private long userId;
	//员工码
	private String userCode;
	//登陆用户名
	private String userName;
	//部门id
	private Long expressId;
	//部门名称
	private String expressName;
	//分销中心码
	private String distributionCode;
	//分销中心名称
	private String distributionName;
	private String merchantBaseInfoId;
	private String sysManager;
	//密码
	private String pwd;
	//站点ID
	private String stationId;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getExpressId() {
		return expressId;
	}
	public void setExpressId(Long expressId) {
		this.expressId = expressId;
	}
	public String getExpressName() {
		return expressName;
	}
	public void setExpressName(String expressName) {
		this.expressName = expressName;
	}
	public String getDistributionCode() {
		return distributionCode;
	}
	public void setDistributionCode(String distributionCode) {
		this.distributionCode = distributionCode;
	}
	public String getDistributionName() {
		return distributionName;
	}
	public void setDistributionName(String distributionName) {
		this.distributionName = distributionName;
	}
	public String getMerchantBaseInfoId() {
		return merchantBaseInfoId;
	}
	public void setMerchantBaseInfoId(String merchantBaseInfoId) {
		this.merchantBaseInfoId = merchantBaseInfoId;
	}
	public String getSysManager() {
		return sysManager;
	}
	public void setSysManager(String sysManager) {
		this.sysManager = sysManager;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
}
