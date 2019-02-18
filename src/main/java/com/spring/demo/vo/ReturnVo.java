package com.spring.demo.vo;

import java.io.Serializable;

public class ReturnVo implements Serializable {

	/**
	 * 响应编码
	 */
	private Integer code;

	/**
	 * 响应消息
	 */
	private String msg;

	/**
	 * 返回对象
	 */
	private Object data;


	public ReturnVo() {
		super();
	}
	
	public ReturnVo(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public ReturnVo(Integer code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
