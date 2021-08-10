package io.emil.study.response.entity;

public class ListResponse {

	private Long status_code;
	private String message;
	private Object data;
	public Long getStatus_code() {
		return status_code;
	}
	public void setStatus_code(Long status_code) {
		this.status_code = status_code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
