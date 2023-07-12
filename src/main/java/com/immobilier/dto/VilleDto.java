package com.immobilier.dto;

import java.util.ArrayList;
import java.util.List;
 

public class VilleDto extends ResponseDto {
	private String uuid;
	private String libelle; 
	private List<CommuneDto> listeCommunesDTO=new ArrayList<>();
	 
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<CommuneDto> getListeCommunesDTO() {
		return listeCommunesDTO;
	}

	public void setListeCommunesDTO(List<CommuneDto> listeCommunesDTO) {
		this.listeCommunesDTO = listeCommunesDTO;
	}

}
