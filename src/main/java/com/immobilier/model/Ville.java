package com.immobilier.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Ville extends AbstractDomainClass{
	
	private String nomVille;
	
	@OneToMany(mappedBy = "ville")
	List<Commune> listCommune;

	public String getNomVille() {
		return nomVille;
	}

	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}

	public List<Commune> getListCommune() {
		return listCommune;
	}

	public void setListCommune(List<Commune> listCommune) {
		this.listCommune = listCommune;
	}

}
