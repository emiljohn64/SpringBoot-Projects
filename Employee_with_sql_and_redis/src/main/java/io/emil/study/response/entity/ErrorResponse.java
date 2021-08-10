package io.emil.study.response.entity;

public class ErrorResponse {

	private String error_message;

	private Long status_code;

	public String getError_message() {
		return error_message;
	}

	public void setError_message(String error_message) {
		this.error_message = error_message;
	}

	public Long getStatus_code() {
		return status_code;
	}

	public void setStatus_code(Long status_code) {
		this.status_code = status_code;
	}
}
