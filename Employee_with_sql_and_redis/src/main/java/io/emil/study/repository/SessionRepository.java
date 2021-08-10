package io.emil.study.repository;

import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.repository.CrudRepository;

import io.emil.study.entity.Session;

@EnableRedisRepositories
public interface SessionRepository extends CrudRepository<Session, Long> {
	
	public Session getByEid(Long eid) throws Exception;
	public Session getByToken(String token) throws Exception;
}
