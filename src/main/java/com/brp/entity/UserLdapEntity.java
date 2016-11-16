package com.brp.entity;

public class UserLdapEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String cn;
	private String ou;
	private String department;
	private String displayName;
	private String givenName;
	private String mobile;
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCn() {
		return cn;
	}

	public void setCn(String cn) {
		this.cn = cn;
	}

	public String getOu() {
		return ou;
	}

	public void setOu(String ou) {
		this.ou = ou;
	}

	@Override
	public String toString() {
		return "UserLdapEntity [cn=" + cn + ", department=" + department + ", displayName=" + displayName
				+ ", givenName=" + givenName + ", mobile=" + mobile + "]";
	}
}
