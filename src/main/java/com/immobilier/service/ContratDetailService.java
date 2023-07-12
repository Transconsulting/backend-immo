package com.immobilier.service;

import java.util.List;

import com.immobilier.dto.ContratDetailDto;
 

public interface ContratDetailService {
	public ContratDetailDto add(ContratDetailDto dto); 
	public ContratDetailDto update(ContratDetailDto dto,String uuid);
	public List<ContratDetailDto> getDetailContrat(String uuidContrat); 
	public ContratDetailDto getByUuid(String uuid);
	public ContratDetailDto delete(String uuid);
}
