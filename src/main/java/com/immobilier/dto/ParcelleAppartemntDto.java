package com.immobilier.dto;
 
 

import com.immobilier.enumeration.StatutDomaine; 

public class ParcelleAppartemntDto extends ResponseDto {
	
	private String uuid;
	private String numero;
	private double prix;
	private String uuidDomaine;
	private String domaine; 
	private Integer caution;
	private String avance;
	private double fraisAgence;
	private StatutDomaine statutDomaine;
	private String uuidProprietaire; 
	private String appDescription;
		
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getUuidDomaine() {
		return uuidDomaine;
	}
	public void setUuidDomaine(String uuidDomaine) {
		this.uuidDomaine = uuidDomaine;
	}
		
	public String getDomaine() {
		return domaine;
	}
	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}
	
	public StatutDomaine getStatutDomaine() {
		return statutDomaine;
	}
	public void setStatutDomaine(StatutDomaine statutDomaine) {
		this.statutDomaine = statutDomaine;
	}
	public Integer getCaution() {
		return caution;
	}
	public void setCaution(Integer caution) {
		this.caution = caution;
	}
	public String getAvance() {
		return avance;
	}
	public void setAvance(String avance) {
		this.avance = avance;
	}
	public double getFraisAgence() {
		return fraisAgence;
	}
	public void setFraisAgence(double fraisAgence) {
		this.fraisAgence = fraisAgence;
	}
	public String getUuidProprietaire() {
		return uuidProprietaire;
	}
	public void setUuidProprietaire(String uuidProprietaire) {
		this.uuidProprietaire = uuidProprietaire;
	}
	public String getAppDescription() {
		return appDescription;
	}
	public void setAppDescription(String appDescription) {
		this.appDescription = appDescription;
	}
		
	
}
