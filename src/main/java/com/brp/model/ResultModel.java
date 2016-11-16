package com.brp.model;

import com.brp.entity.ResultEnum;

/**
 * 缁撴灉绫�
 * 
 * @author Bendo
 *
 */
public class ResultModel<T extends Object> {
	private ResultEnum result;
	private String message;
	private Exception exception;
	private T data;

	public ResultModel() {

	}

	public ResultModel(ResultEnum re, String msg) {
		this.setResult(re);
		this.setMessage(msg);
	}

	public ResultModel(ResultEnum re, String msg, Exception e) {
		this.setResult(re);
		this.setMessage(msg);
		this.setException(e);
	}

	public ResultEnum getResult() {
		return result;
	}

	public void setResult(ResultEnum result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "{" + "result=" + result +
				", message='" + message + '\'' + '}';
	}
}
