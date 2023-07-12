package com.immobilier.service;

import java.util.List;

import com.immobilier.dto.AgenceDto;

public interface AgenceService {

	public AgenceDto saveAgence(AgenceDto agenceDto);
	public AgenceDto updateAgence(AgenceDto agenceDto, String uuid);
	public AgenceDto getByuuidAgence(String uuid);
	public void deleteAgence(String uuid);
	public List<AgenceDto> findAllAgence();
}
