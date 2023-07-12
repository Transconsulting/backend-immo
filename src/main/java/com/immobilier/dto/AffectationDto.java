package com.immobilier.dto;

import java.util.Date;

import com.immobilier.enumeration.TypeTraveaux;

public class AffectationDto extends ResponseDto{
	
	private String uuid;
	private String nomClient;
	private String telClient;
	private String ville;
	private String commune;
	private String quartier;
	private String uuidQuartier;
	private TypeTraveaux typeTravaux;
	private Date dateAffectation;
	private String descripTravau;
	private String uuidAgent;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getTelClient() {
		return telClient;
	}
	public void setTelClient(String telClient) {
		this.telClient = telClient;
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
	public TypeTraveaux getTypeTravaux() {
		return typeTravaux;
	}
	public void setTypeTravaux(TypeTraveaux typeTravaux) {
		this.typeTravaux = typeTravaux;
	}
	public Date getDateAffectation() {
		return dateAffectation;
	}
	public void setDateAffectation(Date dateAffectation) {
		this.dateAffectation = dateAffectation;
	}
	public String getDescripTravau() {
		return descripTravau;
	}
	public void setDescripTravau(String descripTravau) {
		this.descripTravau = descripTravau;
	}
	public String getUuidAgent() {
		return uuidAgent;
	}
	public void setUuidAgent(String uuidAgent) {
		this.uuidAgent = uuidAgent;
	}
	
	

}
