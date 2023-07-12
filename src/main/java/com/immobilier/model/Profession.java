package com.immobilier.model;
 
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany; 

@Entity
public class Profession extends AbstractDomainClass {
	
	private String libelle;
	
	@OneToMany(mappedBy = "profession",fetch = FetchType.LAZY)
	private List<Agent> listeAgent=new ArrayList<Agent>();
	 
	public String getLibelle() {
		return libelle;
	}
	
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public List<Agent> getListeAgent() {
		return listeAgent;
	}
	
	public void setListeAgent(List<Agent> listeAgent) {
		this.listeAgent = listeAgent;
	}
	
	 
}
