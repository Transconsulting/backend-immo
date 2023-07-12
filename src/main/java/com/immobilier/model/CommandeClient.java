package com.immobilier.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CommandeClient extends AbstractDomainClass{
	
	private String numCmd;
	private Date datCmd;
	private double montantCmd;
	private double payer;
	
	@ManyToOne
	@JoinColumn(name = "uuidClient")
	private Client client;
	
	@OneToMany(mappedBy = "commandeClient", fetch = FetchType.LAZY)
	private List<PaiementFacture> listPaiementFacture;
	@OneToMany(mappedBy = "commandeClient", fetch = FetchType.LAZY)
	private List<DetailCommandeClient> listDetailCommandeClient;
	

	public String getNumCmd() {
		return numCmd;
	}

	public void setNumCmd(String numCmd) {
		this.numCmd = numCmd;
	}

	public Date getDatCmd() {
		return datCmd;
	}

	public void setDatCmd(Date datCmd) {
		this.datCmd = datCmd;
	}

	public double getMontantCmd() {
		return montantCmd;
	}

	public void setMontantCmd(double montantCmd) {
		this.montantCmd = montantCmd;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	

	public List<DetailCommandeClient> getListDetailCommandeClient() {
		return listDetailCommandeClient;
	}

	public void setListDetailCommandeClient(List<DetailCommandeClient> listDetailCommandeClient) {
		this.listDetailCommandeClient = listDetailCommandeClient;
	}

	public List<PaiementFacture> getListPaiementFacture() {
		return listPaiementFacture;
	}

	public void setListPaiementFacture(List<PaiementFacture> listPaiementFacture) {
		this.listPaiementFacture = listPaiementFacture;
	}

	public double getPayer() {
		return payer;
	}

	public void setPayer(double payer) {
		this.payer = payer;
	}
	
}
