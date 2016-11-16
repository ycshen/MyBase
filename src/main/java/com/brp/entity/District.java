package com.brp.entity;
/** 
 * <p>Project: BRP</p> 
 * <p>Title: District.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public class District {
	//为了对接 牺牲点代码格式
	private String autoid;
	private String codeofmerchant;
	private String districtid;
	private String districtname;
	public String getAutoid() {
		return autoid;
	}
	public void setAutoid(String autoid) {
		this.autoid = autoid;
	}
	public String getCodeofmerchant() {
		return codeofmerchant;
	}
	public void setCodeofmerchant(String codeofmerchant) {
		this.codeofmerchant = codeofmerchant;
	}
	public String getDistrictid() {
		return districtid;
	}
	public void setDistrictid(String districtid) {
		this.districtid = districtid;
	}
	public String getDistrictname() {
		return districtname;
	}
	public void setDistrictname(String districtname) {
		this.districtname = districtname;
	}
}

