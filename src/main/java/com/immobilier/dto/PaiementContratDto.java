package com.immobilier.dto;

import java.time.LocalDate;

 
 
public class PaiementContratDto extends ResponseDto {
	private String uuid;
	private double montant; 
	private LocalDate datePaiement;
	private String reference; 
	private String uuidContrat;
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
	public String getUuidContrat() {
		return uuidContrat;
	}
	public void setUuidContrat(String uuidContrat) {
		this.uuidContrat = uuidContrat;
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
