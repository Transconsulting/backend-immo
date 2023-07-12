package com.immobilier.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
 
import com.immobilier.enumeration.TypeTraveaux;

@Entity
public class Affectation extends AbstractDomainClass {
	
	private String nomClient;
	private String telClient; 
	private Date dateAffectation;
	private String descripTravau;	
	@Enumerated(EnumType.STRING)
	private TypeTraveaux typeTravaux;
	
	@ManyToOne
	@JoinColumn(name = "uuidAgent")
	private Agent agent;
	@ManyToOne
	@JoinColumn(name = "uuidQuartier")
	private Quartier quartier;
	
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getTelClient() {
		return telClient;
	}
	public void setTelClient(String telClient) {
		this.telClient = telClient;
	}
	public Date getDateAffectation() {
		return dateAffectation;
	}
	public void setDateAffectation(Date dateAffectation) {
		this.dateAffectation = dateAffectation;
	}
	public String getDescripTravau() {
		return descripTravau;
	}
	public void setDescripTravau(String descripTravau) {
		this.descripTravau = descripTravau;
	}
	public TypeTraveaux getTypeTravaux() {
		return typeTravaux;
	}
	public void setTypeTravaux(TypeTraveaux typeTravaux) {
		this.typeTravaux = typeTravaux;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	public Quartier getQuartier() {
		return quartier;
	}
	public void setQuartier(Quartier quartier) {
		this.quartier = quartier;
	}

	 	
}
