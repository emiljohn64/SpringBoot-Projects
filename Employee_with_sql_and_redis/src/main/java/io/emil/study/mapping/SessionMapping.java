package io.emil.study.mapping;


import io.emil.study.dto.SessionDto;
import io.emil.study.entity.Session;

public class SessionMapping {

	public static Session dTODto(SessionDto data) {
		Session modeldata=new Session.SessionBuilder()
				.setEid(data.getEid())
				.setSession_id(data.getSession_id())
				.setLogin_time(data.getLogin_time())
				.setToken(data.getToken())
				.setToken_expiry(data.getToken_expiry())
				.build();
		return modeldata;
		
	}
	public static Session doToDto(Session data) {
		Session modeldata=new Session.SessionBuilder()
				.setEid(data.getEid())
				.setSession_id(data.getSession_id())
				.setLogin_time(data.getLogin_time())
				.setToken(data.getToken())
				.setToken_expiry(data.getToken_expiry())
				.build();
		return modeldata;
		
	}
}
