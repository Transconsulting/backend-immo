package com.immobilier.service;

import java.util.List;

import com.immobilier.dto.AffectationDto;




public interface AffectationService {

	public AffectationDto saveAffectation(AffectationDto affectationDto);
	public AffectationDto updateAffectation( AffectationDto affectationDto, String uuid);
	public AffectationDto getByuuidAffectation(String uuid);
	public void deleteAffectation(String uuid);
	public List<AffectationDto> findAllAffectation();
}
