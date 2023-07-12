package com.immobilier.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Commune extends AbstractDomainClass {
	
	private String nomCommune;
	
	@ManyToOne
	@JoinColumn(name = "uuidVille")
	private Ville ville;
	
	@OneToMany(mappedBy = "commune")
	List<Quartier> listQuartier;

	public String getNomCommune() {
		return nomCommune;
	}

	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public List<Quartier> getListQuartier() {
		return listQuartier;
	}

	public void setListQuartier(List<Quartier> listQuartier) {
		this.listQuartier = listQuartier;
	}

	
}
