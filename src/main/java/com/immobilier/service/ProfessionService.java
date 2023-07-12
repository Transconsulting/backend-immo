package com.immobilier.service;

import java.util.List;
 
import com.immobilier.dto.ProfessionDto;

public interface ProfessionService {
	public ProfessionDto add(ProfessionDto dto); 
	public ProfessionDto update(ProfessionDto dto,String uuid);
	public List<ProfessionDto> findAll();
	public ProfessionDto getByUuid(String uuid);
	void delete(String uuid); 
}
