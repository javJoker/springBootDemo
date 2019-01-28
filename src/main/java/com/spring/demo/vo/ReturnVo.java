package com.spring.demo.vo;

import java.io.Serializable;
import java.util.List;

public class ReturnVo<T> implements Serializable {

	private static final long serialVersionUID = -5580228202640516960L;

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
	private T data;

	public ReturnVo() {
		super();
	}
	
	public ReturnVo(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public ReturnVo(Integer code, String msg, T data, List<T> datas) {
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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
