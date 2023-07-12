package com.immobilier.dto;

public class ParcelleApartemntDetailDto extends ResponseDto{
	
	private String uuid;
	private String libelle;
	private String size;
	private String surface;
	private String appDescription;
	private String uuidParcelleAppartemnt;
	private String numeroParcelleAppartement; 
	
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
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getSurface() {
		return surface;
	}
	public void setSurface(String surface) {
		this.surface = surface;
	}
	public String getUuidParcelleAppartemnt() {
		return uuidParcelleAppartemnt;
	}
	public void setUuidParcelleAppartemnt(String uuidParcelleAppartemnt) {
		this.uuidParcelleAppartemnt = uuidParcelleAppartemnt;
	}
	public String getNumeroParcelleAppartement() {
		return numeroParcelleAppartement;
	}
	public void setNumeroParcelleAppartement(String numeroParcelleAppartement) {
		this.numeroParcelleAppartement = numeroParcelleAppartement;
	}
	public String getAppDescription() {
		return appDescription;
	}
	public void setAppDescription(String appDescription) {
		this.appDescription = appDescription;
	}
 
	
}
