package io.emil.study.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;


@SuppressWarnings("serial")
@RedisHash(timeToLive=7200)
public class Session implements Serializable{
	
	@Id
	@Indexed
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long session_id;
	
	@Indexed
	private Long eid;
	
	@Indexed
	private String token;
	
	private LocalDateTime login_time;
	
	private LocalDateTime token_expiry;
	
	public Long getEid() {
		return eid;
	}

	public LocalDateTime getToken_expiry() {
		return token_expiry;
	}

	public void setToken_expiry(LocalDateTime token_expiry) {
		this.token_expiry = token_expiry;
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

	public Session(Long employee_id, Long session_id, String token, LocalDateTime login_time,
			LocalDateTime token_expiry) {
		this.eid = employee_id;
		this.session_id = session_id;
		this.token = token;
		this.login_time = login_time;
		this.token_expiry = token_expiry;
	}
	public Session() {
		
	}
	
	public Session(SessionBuilder builder) {
		eid = builder.eid;
		session_id = builder.session_id;
		token = builder.token;
		login_time = builder.login_time;
		token_expiry = builder.token_expiry;
	}
	public static class SessionBuilder{
		
		private Long eid;
		
		
		private Long session_id;
		
		private String token;
		
		private LocalDateTime login_time;
		
		private LocalDateTime token_expiry;

		public SessionBuilder setEid(Long employee_id) {
			this.eid = employee_id;
			return this;
		}

		public SessionBuilder setSession_id(Long session_id) {
			this.session_id = session_id;
			return this;
		}

		public SessionBuilder setToken(String token) {
			this.token = token;
			return this;
		}

		public SessionBuilder setLogin_time(LocalDateTime login_time) {
			this.login_time = login_time;
			return this;
		}

		public SessionBuilder setToken_expiry(LocalDateTime token_expiry) {
			this.token_expiry = token_expiry;
			return this;
		}
		public Session build() {
			return new Session(this);
		}
		
	}
	
}
