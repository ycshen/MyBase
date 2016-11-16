package com.brp.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/5/20.
 */
public class AuthParmModel implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 开始IP
     */
    private String ipStart;
    /**
     * 结束IP
     */
    private String ipEnd;
    /**
     * private_key 值
     */
    private String privateKey;

    public String getIpStart() {
        return ipStart;
    }

    public void setIpStart(String ipStart) {
        this.ipStart = ipStart;
    }

    public String getIpEnd() {
        return ipEnd;
    }

    public void setIpEnd(String ipEnd) {
        this.ipEnd = ipEnd;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }
}
