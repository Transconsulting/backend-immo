package com.immobilier.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
 
 
public class ModePaiementDto extends ResponseDto {

	private String uuid;
	private String libelle;  
	@JsonIgnore
	private List<PaiementContratDto> listePaiementsDTO=new ArrayList<>();
	
	public ModePaiementDto() { 
	}
	
	
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
	public List<PaiementContratDto> getListePaiementsDTO() {
		return listePaiementsDTO;
	}
	public void setListePaiementsDTO(List<PaiementContratDto> listePaiementsDTO) {
		this.listePaiementsDTO = listePaiementsDTO;
	}
	
	 
}
