package com.immobilier.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class ModePaiement extends AbstractDomainClass {

	private String libelle; 
	@OneToMany(mappedBy = "modePaiement",fetch = FetchType.LAZY)
	private List<PaiementContrat> listePaiements=new ArrayList<>();
	
	public ModePaiement() { 
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public List<PaiementContrat> getListePaiements() {
		return listePaiements;
	}
	public void setListePaiements(List<PaiementContrat> listePaiements) {
		this.listePaiements = listePaiements;
	}
	 
}
