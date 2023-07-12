package com.immobilier.dto;

public class ParcelleAppartementVideoDto extends ResponseDto {
	
	private String uuid;
	private String uuidParcelleAppartement;
	private String uuidVideo;
	private String libelleVideo;
	
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
	
	public String getUuidVideo() {
		return uuidVideo;
	}
	public void setUuidVideo(String uuidVideo) {
		this.uuidVideo = uuidVideo;
	}
	public String getLibelleVideo() {
		return libelleVideo;
	}
	public void setLibelleVideo(String libelleVideo) {
		this.libelleVideo = libelleVideo;
	}
	 
}
