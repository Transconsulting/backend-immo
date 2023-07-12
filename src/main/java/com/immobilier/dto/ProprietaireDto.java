package com.immobilier.dto;

import java.util.Date;

public class ProprietaireDto extends ResponseDto{
	
	private String uuid;
	private String nom;
	private String prenoms;
	private Date dateNaiss;
	private String tel;
	private String ville;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenoms() {
		return prenoms;
	}
	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
	}
	public Date getDateNaiss() {
		return dateNaiss;
	}
	public void setDateNaiss(Date dateNaiss) {
		this.dateNaiss = dateNaiss;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}

}
