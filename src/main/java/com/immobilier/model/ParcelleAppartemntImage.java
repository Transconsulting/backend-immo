package com.immobilier.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ParcelleAppartemntImage extends AbstractDomainClass {
	
	@ManyToOne
	@JoinColumn(name = "uuid_image")
	private StoredFile image;
	@ManyToOne
	@JoinColumn(name = "uuidParcelleApartemnt")
	private ParcelleAppartemnt parcelleAppartemnt;
	
	public StoredFile getImage() {
		return image;
	}
	
	public void setImage(StoredFile image) {
		this.image = image;
	}
	
	public ParcelleAppartemnt getParcelleAppartemnt() {
		return parcelleAppartemnt;
	}
	
	public void setParcelleAppartemnt(ParcelleAppartemnt parcelleAppartemnt) {
		this.parcelleAppartemnt = parcelleAppartemnt;
	}
	
}
