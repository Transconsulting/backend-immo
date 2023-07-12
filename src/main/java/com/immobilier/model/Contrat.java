package com.immobilier.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;

import com.immobilier.enumeration.TypeContrat;

@Entity
public class Contrat extends AbstractDomainClass {

	private double montant;
	private double payer;
	private boolean etatAvance;
	@Column(name = "regle_paiement")
	private String reglePaiement;
	@Enumerated(EnumType.STRING)
	private TypeContrat typeContrat;
	@ColumnDefault("true")
	private Boolean statutContrat;
	@ManyToOne
	@JoinColumn(name = "uuid_client")
	private Client client=new Client();
	@OneToMany(mappedBy = "contrat", fetch = FetchType.LAZY)
	private List<ContratDetail> listeContratDetails =new ArrayList<>();
	@OneToMany(mappedBy = "contrat",fetch = FetchType.LAZY)
	private List<PaiementContrat> listePaiements=new ArrayList<>();
	
	 
	public Contrat() { 
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public double getPayer() {
		return payer;
	}

	public void setPayer(double payer) {
		this.payer = payer;
	}

	public String getReglePaiement() {
		return reglePaiement;
	}

	public void setReglePaiement(String reglePaiement) {
		this.reglePaiement = reglePaiement;
	}

	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<ContratDetail> getListeContratDetails() {
		return listeContratDetails;
	}

	public void setListeContratDetails(List<ContratDetail> listeContratDetails) {
		this.listeContratDetails = listeContratDetails;
	}

	public List<PaiementContrat> getListePaiements() {
		return listePaiements;
	}

	public void setListePaiements(List<PaiementContrat> listePaiements) {
		this.listePaiements = listePaiements;
	}

	public TypeContrat getTypeContrat() {
		return typeContrat;
	}

	public void setTypeContrat(TypeContrat typeContrat) {
		this.typeContrat = typeContrat;
	}

	public boolean isEtatAvance() {
		return etatAvance;
	}

	public void setEtatAvance(boolean etatAvance) {
		this.etatAvance = etatAvance;
	}

	public boolean isStatutContrat() {
		return statutContrat;
	}

	public void setStatutContrat(boolean statutContrat) {
		this.statutContrat = statutContrat;
	}
		
}
