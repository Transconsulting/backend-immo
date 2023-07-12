package com.immobilier.dto;

import java.util.ArrayList;
import java.util.List;
 

public class CommuneDto extends ResponseDto {
	private String uuid;
	private String libelle; 
	private String uuidVile; 
	private String ville; 
	private List<QuartierDto> listeQuartierDTO=new ArrayList<>();
	
	public CommuneDto() { 
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

	
	
	public String getUuidVile() {
		return uuidVile;
	}

	public void setUuidVile(String uuidVile) {
		this.uuidVile = uuidVile;
	}

	
	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public List<QuartierDto> getListeQuartierDTO() {
		return listeQuartierDTO;
	}

	public void setListeQuartierDTO(List<QuartierDto> listeQuartierDTO) {
		this.listeQuartierDTO = listeQuartierDTO;
	}
	
	 
}
