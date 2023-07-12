package com.immobilier.model;
 
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated; 
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Formula;

import com.immobilier.enumeration.TypeAgent;

@Entity
public class Agent extends AbstractDomainClass{

	private String nom;
	private String prenoms;
	private String tel;  
	@Formula( "CONCAT_WS( ' ', prenoms , nom) ")
	private String nomComplet;
	@Enumerated(EnumType.STRING)
	private TypeAgent type;
	
	@ManyToOne
	@JoinColumn(name = "uuidProfession")
	private Profession profession;
	
	@ManyToOne
	@JoinColumn(name = "uuidQuartier")
	private Quartier quartier;
	
	@OneToMany(mappedBy = "agent")
	private List<Affectation> listAffectation;
	
	@OneToMany(mappedBy = "agent")
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
 
	public List<Domaine> getListDomaine() {
		return listDomaine;
	}
	public void setListDomaine(List<Domaine> listDomaine) {
		this.listDomaine = listDomaine;
	} 
	
		 
	public Profession getProfession() {
		return profession;
	}
	public void setProfession(Profession profession) {
		this.profession = profession;
	}
	public TypeAgent getType() {
		return type;
	}
	public void setType(TypeAgent type) {
		this.type = type;
	}
	public List<Affectation> getListAffectation() {
		return listAffectation;
	}
	public void setListAffectation(List<Affectation> listAffectation) {
		this.listAffectation = listAffectation;
	}
	public Quartier getQuartier() {
		return quartier;
	}
	public void setQuartier(Quartier quartier) {
		this.quartier = quartier;
	}
	
}
