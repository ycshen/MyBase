package com.brp.base;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/** 
 * <p>Project: BRP</p> 
 * <p>Title: Constant.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Component
public class Constant {
	public static final String ZREO = "0";
	public static final String ONE = "1";
	public static final String TWO = "2";
	public static final String THREE = "3";
	public static final String FOUR = "4";
	public static final String RETURN_SUCCESS = "1";
	public static final String RETURN_EXISTCODE = "2";
	public static final String RETURN_EXISTNUM = "3";
	public static final String HK_CODE = "852";
	public static final String MO_CODE = "853";
	public static final Integer AREA_CODE_START = 10;
	public static final Integer AREA_CODE_END = 30;
	
	public static final String[] DIRECT_CONTROLLER_CODE = {"010", "021", "022", "023"}; //直辖市
	public static final String[] DIRECT_CONTROLLER_NAME = {"北京", "上海", "天津", "重庆"}; //直辖市
	public static final String CODE_200 = "200";
	/**
	 * 环境常量
	 */
	public static final String local = "local";
	public static final String test = "test";
	public static final String prod = "prod";
	public static String PMS_PROD;
	public static String PMS_TEST;
	public static String PMS_GET_PROVINCE;
	public static String PMS_GET_PROVINCE_DISTRICT;
	public static String PMS_DISTRICT;
	public static String PMS_GETCITY_PROVINCEID;
	public static String PMS_GETAREA_CITYID;
	public static String PMS_ALLDISTRICT;
	public static String PMS_DISTRICT_TREE;
	public static String PMS_SUBTYPE;
	public static String PMS_DEPTYPE;
	public static String DPS_PROD;
	public static String DPS_GETBILLNO;
	public static String PMS_GETALLBIGAREA;
	public static String PMS_BRMEMPLOYEE;

	
	@Value("${pms.prod}")
	private String pms_prod;
	@Value("${pms.test}")
	private String pms_test;
	@Value("${pms.get.province}")
	private String pms_get_province;
	@Value("${pms.get.province.district}")
	private String pms_get_province_district;
	@Value("${pms.district}")
	private String pms_district;
	@Value("${pms.getcity.provinceid}")
	private String pms_getcity_provinceid;
	@Value("${pms.getarea.cityid}")
	private String pms_getarea_cityid;
	@Value("${pms.alldistrict}")
	private String pms_alldistrict;
	@Value("${pms.district.tree}")
	private String pms_district_tree;
	@Value("${pms.subtype}")
	private String pms_subtype;
	@Value("${pms.deptype}")
	private String pms_deptype;

	@Value("${dps.prod}")
	private String dps_prod;

	@Value("${dps.getbillno}")
	private String getbillno;
	@Value("${pms.getallbigarea}")
	private String pms_getallbigarea;

	@Value("${pms.brpemployee}")
	private String pms_brpemployee;
	
	@PostConstruct
	public void init(){
		PMS_TEST = this.pms_test;
		PMS_PROD = this.pms_prod;
		PMS_GET_PROVINCE = this.pms_get_province;
		PMS_GET_PROVINCE_DISTRICT = this.pms_get_province_district;
		PMS_DISTRICT = this.pms_district;
		PMS_GETCITY_PROVINCEID = this.pms_getcity_provinceid;
		PMS_GETAREA_CITYID = this.pms_getarea_cityid;
		PMS_ALLDISTRICT = this.pms_alldistrict;
		PMS_DISTRICT_TREE = this.pms_district_tree;
		PMS_SUBTYPE = this.pms_subtype;
		PMS_DEPTYPE = this.pms_deptype;
		DPS_PROD = this.dps_prod;
		DPS_GETBILLNO=this.getbillno;
		PMS_GETALLBIGAREA = this.pms_getallbigarea;
		PMS_BRMEMPLOYEE = this.pms_brpemployee;
	}
}

