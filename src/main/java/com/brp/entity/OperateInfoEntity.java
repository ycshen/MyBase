package com.brp.entity;

/**
 * 
 * @author Administrator
 *
 */
public class OperateInfoEntity {

	private Long id;
	/**
	 * 表主键
	 */
	private long tableId;
	/**
	 * 表名
	 */
	private String tableName;
	
	/**
	 * 操作类型
	 */
	private String operateType;
	
	/**
	 * 操作人
	 */
	private String operateUser;
	
	/**
	 * 操作时间
	 */
	private String operateTime;
	
	/**
	 * 备注
	 */
	private String comment;
	
	/**
	 * ip地址
	 */
	private String ip;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getTableId() {
		return tableId;
	}

	public void setTableId(long tableId) {
		this.tableId = tableId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getOperateType() {
		return operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	public String getOperateUser() {
		return operateUser;
	}

	public void setOperateUser(String operateUser) {
		this.operateUser = operateUser;
	}

	public String getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
}
