package com.immobilier.dto;

public class DetailCommandeClientDto extends ResponseDto{
	
	private String uuid;
	private double prixUnitaire;
	private int quantite;
	private String uuidCommande;
	private String uuidMateriel;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
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
	public String getUuidCommande() {
		return uuidCommande;
	}
	public void setUuidCommande(String uuidCommande) {
		this.uuidCommande = uuidCommande;
	}
	public String getUuidMateriel() {
		return uuidMateriel;
	}
	public void setUuidMateriel(String uuidMateriel) {
		this.uuidMateriel = uuidMateriel;
	}
	
}
