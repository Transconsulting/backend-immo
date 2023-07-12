package com.immobilier.service;

import java.util.List;

import com.immobilier.dto.ParcelleApartemntDetailDto;

public interface ParcelleApartemntDetailService {

	ParcelleApartemntDetailDto saveParcelleApartemntDetail(ParcelleApartemntDetailDto ParcelleApartemntDetailDto);
	ParcelleApartemntDetailDto updateParcelleApartemntDetail(ParcelleApartemntDetailDto ParcelleApartemntDetailDto, String uuid);
	ParcelleApartemntDetailDto getByuuid(String uuid);
	void deleteParcelleApartemntDetail(String uuid);
	List<ParcelleApartemntDetailDto> findAllParcelleApartemntDetail();
	List<ParcelleApartemntDetailDto> getParcelleApartemntDetail(String uuidParcelleApartement);

}
 