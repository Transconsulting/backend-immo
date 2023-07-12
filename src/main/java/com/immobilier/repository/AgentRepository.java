package com.immobilier.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.immobilier.model.Agent;

public interface AgentRepository extends JpaRepository<Agent, String> {
	
	public Agent findByTel(String tel);
	public long count();

}
