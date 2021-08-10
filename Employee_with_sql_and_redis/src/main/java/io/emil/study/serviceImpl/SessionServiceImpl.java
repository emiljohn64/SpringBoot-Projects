package io.emil.study.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.emil.study.entity.Employee;
import io.emil.study.entity.Session;
import io.emil.study.entity.Token;
import io.emil.study.repository.SessionRepository;
import io.emil.study.service.SessionService;

@Service
public class SessionServiceImpl implements SessionService {

	@Autowired
	private SessionRepository sessionRepository;
	@Override
	public Session saveData(Session data) throws Exception {
		
		if(data.getEid() == null) {
			throw new Exception("Employee Id Is Required");
		}
		else if (data.getToken() == null) {
			throw new Exception("Token Is Required");
		}
		else if (data.getToken_expiry() == null)
		{
			throw new Exception("Token-Expiry Is Required");
		}

		else {
			try {
				return sessionRepository.save(data);
			} catch (Exception e) 
			{
				throw new Exception(e.getMessage());
			}	
		}
	}
	@Override
	public Session checkActiveSession(Long emp_id) throws Exception {
		try {	
				Session session=sessionRepository.getByEid(emp_id);
				return session;
				
		}catch (Exception e) 
		{
			throw new Exception(e.getMessage());
		}	
	}
	@Override
	public Optional<Session> deleteSession(Long session_id) throws Exception {
		Optional<Session> session;
		if(sessionRepository.findById(session_id) == null) {
			throw new Exception(" Id is not found");
		}

		else {
			try {	session=sessionRepository.findById(session_id);
					sessionRepository.deleteById(session_id);
					return session;
			} catch (Exception e) 
			{
				throw new Exception(e.getMessage());
			}	
	
		}
	}
	@Override
	public Session checkActiveToken(Token token) throws Exception {
		if(token.getToken()==null) {
			throw new Exception("Token is required");
		}
		else
		{
			try {
				Session session=sessionRepository.getByToken(token.getToken());
				//System.out.println(session);
				return session;
			}
			catch(Exception e) {
				throw new Exception("No");
			}
		}
	}
}


