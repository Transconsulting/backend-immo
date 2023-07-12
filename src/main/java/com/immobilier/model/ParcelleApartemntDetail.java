package com.immobilier.model;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class ParcelleApartemntDetail extends AbstractDomainClass{
	
	private String libelle;
	private String size;
	private String unite;
	
	@ManyToOne
	@JoinColumn(name = "uuidParcelleApartemnt")
	private ParcelleAppartemnt parcelleAppartemnt;

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

	public String getUnite() {
		return unite;
	}

	public void setUnite(String unite) {
		this.unite = unite;
	}

	public ParcelleAppartemnt getParcelleAppartemnt() {
		return parcelleAppartemnt;
	}

	public void setParcelleAppartemnt(ParcelleAppartemnt parcelleAppartemnt) {
		this.parcelleAppartemnt = parcelleAppartemnt;
	}

	
	
	
	

}
