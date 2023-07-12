package com.immobilier.dto;

public class ParcelleAppartemntImageDto extends ResponseDto {
	
	private String uuid;
	private String uuidParcelleAppartement;
	private String uuidImage;
	private String libelleImage;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getUuidParcelleAppartement() {
		return uuidParcelleAppartement;
	}
	public void setUuidParcelleAppartement(String uuidParcelleAppartement) {
		this.uuidParcelleAppartement = uuidParcelleAppartement;
	}
	public String getUuidImage() {
		return uuidImage;
	}
	public void setUuidImage(String uuidImage) {
		this.uuidImage = uuidImage;
	}
	public String getLibelleImage() {
		return libelleImage;
	}
	public void setLibelleImage(String libelleImage) {
		this.libelleImage = libelleImage;
	}
	
	

}
