package com.xiacong.common.exception;


import lombok.NoArgsConstructor;

/**
 *	ServiceException
 * @date 2023/5/31 14:13
 * @author yue
 */

@NoArgsConstructor
public class ServiceException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private String msg;
	private String code = SystemCodeInfo.SYSTEM_ERROR.getCode();

	public ServiceException(String msg) {
		super(msg);
		this.msg = msg;
	}
	public ServiceException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}
	public ServiceException(String code,String msg ) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}
	public ServiceException(String msg, String code, Throwable e) {
		super(msg, e);
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


}
