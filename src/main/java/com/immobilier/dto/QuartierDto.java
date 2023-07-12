package com.immobilier.dto;

public class QuartierDto extends ResponseDto  {

	private String uuid;
	private String libelle; 
	private String uuidCommune;
	private String commune; 
	private String ville; 
	
	public String getLibelle() {
		return libelle;
	}
	
	
	public String getUuidCommune() {
		return uuidCommune;
	}


	public void setUuidCommune(String uuidCommune) {
		this.uuidCommune = uuidCommune;
	}


	public String getUuid() {
		return uuid;
	}

	

	public String getCommune() {
		return commune;
	}


	public void setCommune(String commune) {
		this.commune = commune;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public void setUuid(String uuid) {
		this.uuid = uuid;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
}
