package com.immobilier.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.immobilier.enumeration.TypeAnnonce;
import com.immobilier.enumeration.StatutDomaine;
import com.immobilier.enumeration.TypeDomaine;

@Entity
public class Domaine extends AbstractDomainClass{
	
	private String libelle;
	private String longitude;
	private String lattitude; 
	@Enumerated(EnumType.STRING)
	private TypeDomaine type; //Containts ##Parcelle ##Immeuble ## Villa
	@Enumerated(EnumType.STRING)
	private StatutDomaine statut;//A vendre ou A loué 
	@Enumerated(EnumType.STRING)
	private TypeAnnonce typeAnonce;
	
	@ManyToOne
	@JoinColumn(name = "uuidQuartier")
	private Quartier quartier;
	
	@ManyToOne
	@JoinColumn(name = "uuidAgent")
	private Agent agent;

	@ManyToOne
	@JoinColumn(name = "uuidProprietaire")
	private Proprietaire proprietaire;
	
	@OneToMany(mappedBy = "domaine",fetch = FetchType.LAZY)
	private List<ParcelleAppartemnt> listParcelleAppartemnt;
	
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	public Proprietaire getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}
	
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public TypeDomaine getType() {
		return type;
	}
	public void setType(TypeDomaine type) {
		this.type = type;
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
		 
	public Quartier getQuartier() {
		return quartier;
	}
	public void setQuartier(Quartier quartier) {
		this.quartier = quartier;
	}
	public StatutDomaine getStatut() {
		return statut;
	}
	public void setStatut(StatutDomaine statut) {
		this.statut = statut;
	}
	
	
	public TypeAnnonce getTypeAnonce() {
		return typeAnonce;
	}
	public void setTypeAnonce(TypeAnnonce typeAnonce) {
		this.typeAnonce = typeAnonce;
	}
	public List<ParcelleAppartemnt> getListParcelleAppartemnt() {
		return listParcelleAppartemnt;
	}
	public void setListParcelleAppartemnt(List<ParcelleAppartemnt> listParcelleAppartemnt) {
		this.listParcelleAppartemnt = listParcelleAppartemnt;
	}
	
	

}
