package com.immobilier.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Interese extends AbstractDomainClass{
	
	@ManyToOne
	@JoinColumn(name = "uuidParcel")
	private ParcelleAppartemnt parcelleAppartemnt;
	@ManyToOne
	@JoinColumn(name = "uuidUtilisateur")
	private Utilisateur utilisateur;
	
	public Interese() { 
	}

	public ParcelleAppartemnt getParcelleAppartemnt() {
		return parcelleAppartemnt;
	}

	public void setParcelleAppartemnt(ParcelleAppartemnt parcelleAppartemnt) {
		this.parcelleAppartemnt = parcelleAppartemnt;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	} 
	
}
