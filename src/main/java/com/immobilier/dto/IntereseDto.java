package com.immobilier.dto;

import java.util.Date;

public class IntereseDto extends ResponseDto{
	private String uuid; 
	private Date created_at;
	private Date updated_at;
	private ParcelleAppartemntDto parcelleAppartemnt; 
	private UtilisateurDto utilisateur;
	 
	public IntereseDto() {
		
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public ParcelleAppartemntDto getParcelleAppartemnt() {
		return parcelleAppartemnt;
	}

	public void setParcelleAppartemnt(ParcelleAppartemntDto parcelleAppartemnt) {
		this.parcelleAppartemnt = parcelleAppartemnt;
	}

	public UtilisateurDto getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(UtilisateurDto utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
 
}
