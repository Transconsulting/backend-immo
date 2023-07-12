package com.immobilier.service;

import java.util.List;

import com.immobilier.dto.ParcelleAppartemntDto;
import com.immobilier.enumeration.StatutDomaine;


public interface ParcelleAppartemntService {
	
	ParcelleAppartemntDto saveParcelleAppartemnt(ParcelleAppartemntDto parcelleAppartemntDto);
	ParcelleAppartemntDto updateParcelleAppartemnt(ParcelleAppartemntDto parcelleAppartemntDto,String uuid);
	ParcelleAppartemntDto getByuuid(String uuid);
	void deleteParcelleAppartemnt(String uuid);
	List<ParcelleAppartemntDto> findAllParcelleAppartemnt();
	ParcelleAppartemntDto statutAppartementParcelle(StatutDomaine statut,String uuidParcelleApp);
	
	List<ParcelleAppartemntDto> findAllByStatut(StatutDomaine statut);
	List<ParcelleAppartemntDto> findAllByStatutAndDomaine(StatutDomaine statut,String uuidDommaine);
	Integer getTotalByStatut(StatutDomaine statut);
	
}
