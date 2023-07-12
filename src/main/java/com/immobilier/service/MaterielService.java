package com.immobilier.service;

import java.util.List;
 
import com.immobilier.dto.MaterielDto;

public interface MaterielService {
	public MaterielDto add(MaterielDto dto); 
	public MaterielDto update(MaterielDto dto,String uuid);
	public List<MaterielDto> findAll();
	public MaterielDto getByUuid(String uuid);
	void delete(String uuid); 
}
