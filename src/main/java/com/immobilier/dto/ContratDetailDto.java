package com.immobilier.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;



public class ContratDetailDto extends ResponseDto {
	private String uuid;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate debut;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate fin;  
	private double prixLoyer;
	private double caution; 
	private double avance; 
	private double fraisAgence; 
	private String uuidContrat;
	private String uuidParcelApp;
	private String numeroParcelApp;
	private String uuidproprietaire;
	private String uuidDomaine;
	private String domaine;
	
	
	public ContratDetailDto() { 
	}


	public String getUuid() {
		return uuid;
	}


	public void setUuid(String uuid) {
		this.uuid = uuid;
	}


	public LocalDate getDebut() {
		return debut;
	}


	public void setDebut(LocalDate debut) {
		this.debut = debut;
	}


	public LocalDate getFin() {
		return fin;
	}


	public void setFin(LocalDate fin) {
		this.fin = fin;
	}


	public double getPrixLoyer() {
		return prixLoyer;
	}


	public void setPrixLoyer(double prixLoyer) {
		this.prixLoyer = prixLoyer;
	}


	public double getCaution() {
		return caution;
	}


	public void setCaution(double caution) {
		this.caution = caution;
	}


	public double getAvance() {
		return avance;
	}


	public void setAvance(double avance) {
		this.avance = avance;
	}


	public double getFraisAgence() {
		return fraisAgence;
	}


	public void setFraisAgence(double fraisAgence) {
		this.fraisAgence = fraisAgence;
	}


	public String getUuidContrat() {
		return uuidContrat;
	}


	public void setUuidContrat(String uuidContrat) {
		this.uuidContrat = uuidContrat;
	}


	public String getUuidParcelApp() {
		return uuidParcelApp;
	}


	public void setUuidParcelApp(String uuidParcelApp) {
		this.uuidParcelApp = uuidParcelApp;
	}


	public String getNumeroParcelApp() {
		return numeroParcelApp;
	}


	public void setNumeroParcelApp(String numeroParcelApp) {
		this.numeroParcelApp = numeroParcelApp;
	}


	public String getUuidproprietaire() {
		return uuidproprietaire;
	}


	public void setUuidproprietaire(String uuidproprietaire) {
		this.uuidproprietaire = uuidproprietaire;
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
	
}
