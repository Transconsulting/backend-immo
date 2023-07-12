package com.immobilier.service;

import java.util.List;

import com.immobilier.dto.AgentDto;

public interface AgentService {

	AgentDto saveAgent(AgentDto agentDto);
	AgentDto updateAgent(AgentDto agentDto, String uuid);
	AgentDto getByuuid(String uuid);
	public void deleteAgent(String uuid);
	List<AgentDto> findAllAgent();
	long getTotalAgent();
}
 