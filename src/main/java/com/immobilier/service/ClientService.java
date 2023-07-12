package com.immobilier.service;

import java.util.List;

import com.immobilier.dto.ClientDto;

public interface ClientService {
	public ClientDto add(ClientDto dto); 
	public ClientDto update(ClientDto dto,String uuid);
	public List<ClientDto> findAll();
	public ClientDto getByUuid(String uuid);
	ClientDto delete(String uuid); 
	long getTotalClient();
}
