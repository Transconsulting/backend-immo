package com.immobilier.service;

import java.util.List;

import com.immobilier.dto.CommandeClientDto;
import com.immobilier.dto.DetailCommandeClientDto; 

public interface CommandeClientService {

	CommandeClientDto add(CommandeClientDto dto);
	CommandeClientDto update(CommandeClientDto dto,String uuid);
	CommandeClientDto findByUuid(String uuid);
	CommandeClientDto findByNumFacture(String code);
	List<DetailCommandeClientDto> getDetailCommandeClient(String uuidCmd);
	List<CommandeClientDto> findAll();
	CommandeClientDto delete(String uuid);
}
