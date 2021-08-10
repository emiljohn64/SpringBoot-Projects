package io.emil.study.dto;

import java.time.LocalDateTime;


public class SessionDto {

	private Long eid;
	
	private Long session_id;
	
	private String token;
	
	private LocalDateTime login_time;
	
	private LocalDateTime token_expiry;

	public Long getEid() {
		return eid;
	}

	public void setEid(Long employee_id) {
		this.eid = employee_id;
	}

	public Long getSession_id() {
		return session_id;
	}

	public void setSession_id(Long session_id) {
		this.session_id = session_id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

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

	public SessionDto(Long employee_id, Long session_id, String token, LocalDateTime login_time,
			LocalDateTime token_expiry) {
		this.eid = employee_id;
		this.session_id = session_id;
		this.token = token;
		this.login_time = login_time;
		this.token_expiry = token_expiry;
	}
	public SessionDto() {
		
	}
	
	public SessionDto(SessionDtoBuilder builder) {
		eid = builder.eid;
		session_id = builder.session_id;
		token = builder.token;
		login_time = builder.login_time;
		token_expiry = builder.token_expiry;
	}

	public static class SessionDtoBuilder {
		private Long eid;
		
		private Long session_id;
		
		private String token;
		
		private LocalDateTime login_time;
		
		private LocalDateTime token_expiry;

		public SessionDtoBuilder setEid(Long employee_id) {
			this.eid = employee_id;
			return this;
		}

		public SessionDtoBuilder setSession_id(Long session_id) {
			this.session_id = session_id;
			return this;
		}

		public SessionDtoBuilder setToken(String token) {
			this.token = token;
			return this;
		}

		public SessionDtoBuilder setLogin_time(LocalDateTime login_time) {
			this.login_time = login_time;
			return this;
		}

		public SessionDtoBuilder setToken_expiry(LocalDateTime token_expiry) {
			this.token_expiry = token_expiry;
			return this;
		}
		public SessionDto build() {
			return new SessionDto(this);
		}
	}
	
}
