package com.immobilier.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class DetailCommandeClient extends AbstractDomainClass{

	private double prixUnitaire;
	private int quantite;
	
	@ManyToOne
	@JoinColumn(name = "uuidMateriel")
	private Materiel materiel;
	
	@ManyToOne
	@JoinColumn(name = "uuidCommande")
	private CommandeClient commandeClient;

	public double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Materiel getMateriel() {
		return materiel;
	}

	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}

	public CommandeClient getCommande() {
		return commandeClient;
	}

	public void setCommande(CommandeClient commandeClient) {
		this.commandeClient = commandeClient;
	}
	
	
}
