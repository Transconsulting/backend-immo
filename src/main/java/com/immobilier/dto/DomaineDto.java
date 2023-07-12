package com.immobilier.dto;

import com.immobilier.enumeration.TypeAnnonce;
import com.immobilier.enumeration.StatutDomaine;
import com.immobilier.enumeration.TypeDomaine;

public class DomaineDto extends ResponseDto {

	private String uuid;
	private TypeDomaine type; //Containts ##Parcelle ##Immeuble ##Villa
	private String libelle; 
	private String longitude;
	private String lattitude;
	private String ville;
	private String commune;
	private String quartier;
	private String uuidQuartier;
	private StatutDomaine statutDomaine;// A vendre ou A loué
	private TypeAnnonce typeAnonce;
	private String uuidAgent;
	private String agent;
	private String uuidProprietaire;
	private String proprietaire;
	private String telephoneProprietaire;
	
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	
	public TypeDomaine getType() {
		return type;
	}

	public void setType(TypeDomaine type) {
		this.type = type;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLattitude() {
		return lattitude;
	}
	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
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
	
	public String getUuidAgent() {
		return uuidAgent;
	}
	public void setUuidAgent(String uuidAgent) {
		this.uuidAgent = uuidAgent;
	}
	public String getUuidProprietaire() {
		return uuidProprietaire;
	}
	public void setUuidProprietaire(String uuidProprietaire) {
		this.uuidProprietaire = uuidProprietaire;
	}

	public String getTelephoneProprietaire() {
		return telephoneProprietaire;
	}

	public void setTelephoneProprietaire(String telephoneProprietaire) {
		this.telephoneProprietaire = telephoneProprietaire;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}

	public TypeAnnonce getTypeAnonce() {
		return typeAnonce;
	}

	public void setTypeAnonce(TypeAnnonce typeAnonce) {
		this.typeAnonce = typeAnonce;
	}

	public StatutDomaine getStatutDomaine() {
		return statutDomaine;
	}

	public void setStatutDomaine(StatutDomaine statutDomaine) {
		this.statutDomaine = statutDomaine;
	}

	public String getUuidQuartier() {
		return uuidQuartier;
	}

	public void setUuidQuartier(String uuidQuartier) {
		this.uuidQuartier = uuidQuartier;
	}
		
}
