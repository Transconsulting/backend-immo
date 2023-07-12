package com.immobilier.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Proprietaire extends AbstractDomainClass {
	
	private String nom;
	private String prenoms;
	private Date dateNaiss;
	private String tel;
	private String ville;
	
	@OneToMany(mappedBy = "proprietaire")
	private List<Domaine> listDomaine;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenoms() {
		return prenoms;
	}

	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
	}

	public Date getDateNaiss() {
		return dateNaiss;
	}

	public void setDateNaiss(Date dateNaiss) {
		this.dateNaiss = dateNaiss;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public List<Domaine> getListDomaine() {
		return listDomaine;
	}

	public void setListDomaine(List<Domaine> listDomaine) {
		this.listDomaine = listDomaine;
	}
	
	
}
