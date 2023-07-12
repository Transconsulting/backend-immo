package com.immobilier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.immobilier.dto.AgentDto;
import com.immobilier.serviceImple.AgentServiceImple;

@CrossOrigin
@RestController
public class AgentController {
	
	@Autowired
	AgentServiceImple agentServiceImple;
	
	@PostMapping("/agent")
	public AgentDto ajoutAgent(@RequestBody AgentDto agentDto) {		
		return agentServiceImple.saveAgent(agentDto);
	}
	
	@PutMapping("/agent/{uuid}")
	public AgentDto modifierAgent(@RequestBody AgentDto agentDto, @PathVariable String uuid) {		
		return agentServiceImple.updateAgent(agentDto, uuid);
	}
	
	@DeleteMapping("/agent/{uuid}")
	public void supprimerAgent(@PathVariable String uuid) {
		agentServiceImple.deleteAgent(uuid);
	}
	
	@GetMapping("/agent/{uuid}")
	public AgentDto rechercherAgent(@PathVariable String uuid) {
		return agentServiceImple.getByuuid(uuid);
	}
	
	@GetMapping("/agent")
	public List<AgentDto> afficherAgent(){
		return agentServiceImple.findAllAgent();
	}
	
	@GetMapping("/agent/total")
	public long getTotalAgent(){
		return agentServiceImple.getTotalAgent();
	}
}
