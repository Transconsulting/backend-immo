package com.immobilier.dto;

import java.time.LocalDate;

 
 
public class PaiementFactureDto extends ResponseDto {
	
	private String uuid;
	private double montant; 
	private LocalDate datePaiement;
	private String reference; 
	private String uuidCommande;
	private String uuidModePaiement;
	
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public LocalDate getDatePaiement() {
		return datePaiement;
	}
	public void setDatePaiement(LocalDate datePaiement) {
		this.datePaiement = datePaiement;
	}
	public String getReference() {
		return reference;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
		
	public String getUuidCommande() {
		return uuidCommande;
	}
	public void setUuidCommande(String uuidCommande) {
		this.uuidCommande = uuidCommande;
	}
	public String getUuidModePaiement() {
		return uuidModePaiement;
	}
	public void setUuidModePaiement(String uuidModePaiement) {
		this.uuidModePaiement = uuidModePaiement;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	
}
