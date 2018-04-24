package com.itheima.crm.domain;

/**
 * 响应结果
 */
public class ResResult {

	private Boolean success; // 是否操作成功
	private String message; // 消息

	public ResResult() {
	}

	public ResResult(Boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
