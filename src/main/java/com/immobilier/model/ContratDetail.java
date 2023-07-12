package com.immobilier.model;

import java.time.LocalDate;
 
import javax.persistence.Entity; 
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne; 

@Entity
public class ContratDetail extends AbstractDomainClass {
	private LocalDate debut;
	private LocalDate fin; 
	private double prixLoyer;
	private double caution;
	private double avance; 
	private double fraisAgence;
	@ManyToOne
	@JoinColumn(name = "uuid_contrat")
	private Contrat contrat=new Contrat();
	@ManyToOne
	@JoinColumn(name = "uuid_appartement_parcelle")
	private ParcelleAppartemnt parcelleAppartemnt=new ParcelleAppartemnt(); 
	
	public ContratDetail() { 
	}

	public LocalDate getDebut() {
		return debut;
	}

	public void setDebut(LocalDate debut) {
		this.debut = debut;
	}

	public LocalDate getFin() {
		return fin;
	}

	public void setFin(LocalDate fin) {
		this.fin = fin;
	}

	
	public double getPrixLoyer() {
		return prixLoyer;
	}

	public void setPrixLoyer(double prixLoyer) {
		this.prixLoyer = prixLoyer;
	}
	 
	public double getCaution() {
		return caution;
	}

	public void setCaution(double caution) {
		this.caution = caution;
	}

	 
	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	public ParcelleAppartemnt getParcelleAppartemnt() {
		return parcelleAppartemnt;
	}

	public void setParcelleAppartemnt(ParcelleAppartemnt parcelleAppartemnt) {
		this.parcelleAppartemnt = parcelleAppartemnt;
	}

	public double getAvance() {
		return avance;
	}

	public void setAvance(double avance) {
		this.avance = avance;
	}

	public double getFraisAgence() {
		return fraisAgence;
	}

	public void setFraisAgence(double fraisAgence) {
		this.fraisAgence = fraisAgence;
	}
	

}
