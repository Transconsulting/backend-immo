package com.immobilier.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ParcelleAppartementVideo extends AbstractDomainClass {
	
	@ManyToOne
	@JoinColumn(name = "uuid_image")
	private StoredFile video;
	@ManyToOne
	@JoinColumn(name = "uuidParcelleApartemnt")
	private ParcelleAppartemnt parcelleAppartemnt;
	
	public StoredFile getVideo() {
		return video;
	}

	public void setVideo(StoredFile video) {
		this.video = video;
	}

	public ParcelleAppartemnt getParcelleAppartemnt() {
		return parcelleAppartemnt;
	}
	
	public void setParcelleAppartemnt(ParcelleAppartemnt parcelleAppartemnt) {
		this.parcelleAppartemnt = parcelleAppartemnt;
	}
	
}
