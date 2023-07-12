package com.immobilier.service.clientImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.immobilier.dto.client.PropertyDto;
import com.immobilier.enumeration.StatutDomaine; 
import com.immobilier.mapper.client.MapperClient;
import com.immobilier.model.ParcelleAppartemnt;
import com.immobilier.repository.DomaineRepository;
import com.immobilier.repository.ParcelleAppartemntImageRepository;
import com.immobilier.repository.ParcelleAppartemntRepository;
import com.immobilier.service.client.PropertyService;

@Service
public class PropertyServiceImp implements PropertyService {

	@Autowired
	ParcelleAppartemntRepository parcelleAppartemntRepository;
	@Autowired
	DomaineRepository domaineRepository;
	@Autowired
	ParcelleAppartemntImageRepository parcelleAppartemntImageRepository;
	
	@Override
	public List<PropertyDto> listeProperty() {
		List<ParcelleAppartemnt> parcelleAppartemnts = parcelleAppartemntRepository.findAllByStatutOrderByDateCreatedDesc(StatutDomaine.ANNONCE);
		List<PropertyDto> propertyDto = new ArrayList<PropertyDto>(); 
		parcelleAppartemnts.forEach(val -> { 
			val.setParcelleAppartemntImage(parcelleAppartemntImageRepository.findAllImageByParcelleAppartemnt(val.getUuid()));
			propertyDto.add(MapperClient.toPropertyDto(val));
		});
		return propertyDto; 
	}

	@Override
	public List<PropertyDto> listePropertyByAgent(String nomComplet) { 
		//List<ParcelleAppartemnt> parcelleAppartemnts = parcelleAppartemntRepository.findAllByStatutAndDomaineAgentNomContaining(StatutDomaine.ANNONCE,nomComplet);
	List<ParcelleAppartemnt> parcelleAppartemnts = parcelleAppartemntRepository.findAllByStatutAndDomaineAgentNomCompletContaining(StatutDomaine.ANNONCE,nomComplet);	
	List<PropertyDto> propertyDto = new ArrayList<PropertyDto>(); 
		parcelleAppartemnts.forEach(parcelleAppartement -> propertyDto.add(MapperClient.toPropertyDto(parcelleAppartement)));
		return propertyDto; 
	}

	@Override
	public List<PropertyDto> listePropertyByDommaineNom(String titre) {
		List<ParcelleAppartemnt> parcelleAppartemnts = parcelleAppartemntRepository.findAllByStatutAndDomaineLibelleStartingWith(StatutDomaine.ANNONCE,titre);
		List<PropertyDto> propertyDto = new ArrayList<PropertyDto>(); 
		parcelleAppartemnts.forEach(parcelleAppartement -> propertyDto.add(MapperClient.toPropertyDto(parcelleAppartement)));
		return propertyDto; 
	}

	@Override
	public List<PropertyDto> listePropertyByDommaineUuid(String uuid) {
		List<ParcelleAppartemnt> parcelleAppartemnts = parcelleAppartemntRepository.findAllByStatutAndDomaineUuid(StatutDomaine.ANNONCE,uuid);
		List<PropertyDto> propertyDto = new ArrayList<PropertyDto>(); 
		parcelleAppartemnts.forEach(parcelleAppartement -> propertyDto.add(MapperClient.toPropertyDto(parcelleAppartement)));
		return propertyDto; 
	}

}
