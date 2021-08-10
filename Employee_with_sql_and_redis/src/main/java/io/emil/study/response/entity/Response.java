package io.emil.study.response.entity;

import java.time.LocalDateTime;

public class Response {

	private Long status_code;
	private String message;
	private Object data;
	private String access_token;
	private LocalDateTime login_time;
	private LocalDateTime token_expiry;
	
	public LocalDateTime getLogin_time() {
		return login_time;
	}
	public void setLogin_time(LocalDateTime login_time) {
		this.login_time = login_time;
	}
	public LocalDateTime getToken_expiry() {
		return token_expiry;
	}
	public void setToken_expiry(LocalDateTime token_expiry) {
		this.token_expiry = token_expiry;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
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
