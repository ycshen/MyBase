package com.brp.entity;

/**
 * 公共常量
 *
 * @author hexj
 */
public final class Constant {
	/**
	 * 操作成功标识
	 */
	public static final String RESULT_SUCCESS = "SUCCESS";

	/**
	 * 操作失败标识
	 */
	public static final String RESULT_FAIL = "FAIL";
	/**
	 * 操作错误标识
	 */
	public static final String RESULT_ERROR = "ERROR";


	/**
	 * 可用状态
	 */
	public static final Integer ENABLE = 1;


	/**
	 * 不可用状态
	 */
	public static final Integer DISABLE = 0;

	/**
	 * 入库类型：整箱
	 */
	public static final Integer IN_TYPE_BOX = 1;

	/**
	 * 入库类型：散单
	 */
	public static final Integer IN_TYPE_SINGLE = 2;


	/**
	 * 入库状态
	 */
	public static final Integer IN_STATUS = 1;

	/**
	 * 出库状态
	 */
	public static final Integer OUT_STATUS= 2;


	/**
	 * 空值占位符
	 */
	public static final String NULL_LAG = "--";

	/**
	 * 符号"_"
	 */
	public static final String STR_UNDERLINE = "_";

	/**
	 * 符号"_"
	 */
	public static final String STR_STRIGULA = "-";

	/**
	 * 符号"|"
	 */
	public static final String STR_UNDERLINE_PLUS = "|";

	/**
	 * 提示信息KEY
	 */
	public static final String MSG = "MSG";

	/**
	 * 已经存在
	 */
	public static final String IS_EXIST = "isExist";

	/**
	 * 全局user key
	 */
	public static final String ACCOUNT = "account";


	/**
	 * 初始序列号
	 */
	public static final String MIN_SERIAL_NUMBER = "0000000000";

	public static final long TOTOLE_BILL_AMOUNT =10_000_000_000L;


	/**
	 * Redis 缓存过期时间
	 */
	public static final Integer REDIS_EXPIRE =3000;

	public static final String MICRO_USRER_TEST_URL ="http://micro.wltest.com/open/oauth2/validation?access_token=";

	public static final String MICRO_USRER_SERVER_URL ="http://micro.rfddc.com/open/oauth2/validation?access_token=";

	/**
	 * 会员等级编码
	 */
	public static final String VIPCODE = "VIPLEVEL";
	
	/**
	 * 存在
	 */
	public static final Integer EXIST = 1;
	/**
	 * 不存在
	 */
	public static final Integer NO_EXIST = 0;
}
