package com.immobilier.service;

import java.util.List;

import com.immobilier.dto.ParcelleAppartemntImageDto;

public interface ParcelleAppartemntImageService {
	
	ParcelleAppartemntImageDto	addParcelleAppartemntImage(ParcelleAppartemntImageDto parcelleAppartemenntAppartemntImageDto);
	ParcelleAppartemntImageDto	updateParcelleAppartemntImage(ParcelleAppartemntImageDto parcelleAppartemenntAppartemntImageDto,String uuid);
	List<ParcelleAppartemntImageDto> findAll();
	List<ParcelleAppartemntImageDto> findAllByParcelleAppartemnt(String uuid);
	ParcelleAppartemntImageDto getParcelleAppartemntImage(String uuid);
	void deleteParcelleAppartemntImage(String uuid);
	

}
