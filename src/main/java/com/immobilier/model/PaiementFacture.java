package com.immobilier.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PaiementFacture extends AbstractDomainClass {
	private double montant;
	@Column(name = "date_paiement")
	private LocalDate datePaiement;
	private String reference;
	@ManyToOne
	@JoinColumn(name = "uuid_cmd")
	private CommandeClient commandeClient=new CommandeClient();
	@ManyToOne
	@JoinColumn(name = "uuid_mode_paiement")
	private ModePaiement modePaiement=new ModePaiement();
	
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
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	public CommandeClient getCommande() {
		return commandeClient;
	}
	public void setCommande(CommandeClient commandeClient) {
		this.commandeClient = commandeClient;
	}
	public ModePaiement getModePaiement() {
		return modePaiement;
	}
	public void setModePaiement(ModePaiement modePaiement) {
		this.modePaiement = modePaiement;
	}

	
}
