package com.immobilier.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Client extends AbstractDomainClass {

	private String nom;
	private String prenom;
	private String telephone;
	@Column(name = "date_naissance")
	private LocalDate dateNaissance;
	@Column(name = "etat_civil")
	private String etatCivil;
	@Column(name = "nombre_enfant")
	private String nombreEnfant;
	@OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
	private  List<Contrat> listeContrat=new ArrayList<>();
	@OneToMany(mappedBy = "client",fetch = FetchType.LAZY) 
	private  List<CommandeClient> listeCommandeClient=new ArrayList<>();
	
	public Client() { 
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEtatCivil() {
		return etatCivil;
	}

	public void setEtatCivil(String etatCivil) {
		this.etatCivil = etatCivil;
	}

	public String getNombreEnfant() {
		return nombreEnfant;
	}

	public void setNombreEnfant(String nombreEnfant) {
		this.nombreEnfant = nombreEnfant;
	}

	public List<Contrat> getListeContrat() {
		return listeContrat;
	}

	public void setListeContrat(List<Contrat> listeContrat) {
		this.listeContrat = listeContrat;
	}

	public List<CommandeClient> getListeCommandeClient() {
		return listeCommandeClient;
	}

	public void setListeCommandeClient(List<CommandeClient> listeCommandeClient) {
		this.listeCommandeClient = listeCommandeClient;
	}
	
	
}
