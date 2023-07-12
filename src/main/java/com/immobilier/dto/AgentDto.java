package com.immobilier.dto;

import com.immobilier.enumeration.TypeAgent; 

public class AgentDto extends ResponseDto{
	
	private String uuid;
	private String nom;
	private String prenoms;
	private String tel;
	private String uuidProfession;
	private String profession;
	private TypeAgent type;
	private String ville;
	private String commune;
	private String quartier;
	private String uuidQuartier; 
	
	public String getUuid() {
		return uuid;
	}
	
	
	public String getProfession() {
		return profession;
	}


	public void setProfession(String profession) {
		this.profession = profession;
	}


	public TypeAgent getType() {
		return type;
	}


	public void setType(TypeAgent type) {
		this.type = type;
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


	public String getCommune() {
		return commune;
	}


	public void setCommune(String commune) {
		this.commune = commune;
	}

	public String getQuartier() {
		return quartier;
	}

	public void setQuartier(String quartier) {
		this.quartier = quartier;
	}

	public String getUuidQuartier() {
		return uuidQuartier;
	}

	public void setUuidQuartier(String uuidQuartier) {
		this.uuidQuartier = uuidQuartier;
	}


	public String getUuidProfession() {
		return uuidProfession;
	}


	public void setUuidProfession(String uuidProfession) {
		this.uuidProfession = uuidProfession;
	}
	
 
}
