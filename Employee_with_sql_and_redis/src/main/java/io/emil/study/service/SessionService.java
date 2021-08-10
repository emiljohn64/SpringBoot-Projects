package io.emil.study.service;

import java.util.Optional;

import io.emil.study.entity.Employee;
import io.emil.study.entity.Session;
import io.emil.study.entity.Token;

public interface SessionService {

	public Session saveData(Session data) throws Exception;
	public Session checkActiveSession(Long emp_id) throws Exception;
	public Optional<Session> deleteSession(Long session_id) throws Exception;
	public Session checkActiveToken(Token token) throws Exception;
}
