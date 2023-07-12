package com.immobilier.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Quartier extends AbstractDomainClass {
	
	private String nomQuarier;
	
	@ManyToOne
	@JoinColumn(name = "uuidCommune")
	private Commune commune;
	
	@OneToMany(mappedBy = "quartier",fetch = FetchType.LAZY)
	List<Agent> listeAgent=new ArrayList<>();
	
	@OneToMany(mappedBy = "quartier",fetch = FetchType.LAZY)
	List<Domaine> listeDomaine=new ArrayList<>();

	public String getNomQuartier() {
		return nomQuarier;
	}

	public void setNomQuartier(String nomQuarier) {
		this.nomQuarier = nomQuarier;
	}

	public Commune getCommune() {
		return commune;
	}

	public void setCommune(Commune commune) {
		this.commune = commune;
	}

	
}
