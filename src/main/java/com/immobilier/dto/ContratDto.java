package com.immobilier.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.immobilier.enumeration.TypeContrat;
 
 
public class ContratDto extends ResponseDto {

	private String uuid;
	private double montant;
	private double payer; 
	private boolean etatAvance;
	private String reglePaiement;
	private TypeContrat typeContrat;
	private Boolean statutContrat;
	private String uuidClient;
	private String client; 
	private String telephoneClient; 
	@JsonIgnore
	private List<ContratDetailDto> listeContratDetailsDTO =new ArrayList<>(); 
	@JsonIgnore
	private List<PaiementContratDto> listePaiementsDTO=new ArrayList<>();
	
	
	public ContratDto() { 
	}

	
	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}


	public String getTelephoneClient() {
		return telephoneClient;
	}



	public void setTelephoneClient(String telephoneClient) {
		this.telephoneClient = telephoneClient;
	}



	public String getUuid() {
		return uuid;
	}


	public void setUuid(String uuid) {
		this.uuid = uuid;
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

	
 
	public TypeContrat getTypeContrat() {
		return typeContrat;
	}


	public void setTypeContrat(TypeContrat typeContrat) {
		this.typeContrat = typeContrat;
	}


	public String getUuidClient() {
		return uuidClient;
	}


	public void setUuidClient(String uuidClient) {
		this.uuidClient = uuidClient;
	}




	public List<ContratDetailDto> getListeContratDetailsDTO() {
		return listeContratDetailsDTO;
	}


	public void setListeContratDetailsDTO(List<ContratDetailDto> listeContratDetailsDTO) {
		this.listeContratDetailsDTO = listeContratDetailsDTO;
	}


	public List<PaiementContratDto> getListePaiementsDTO() {
		return listePaiementsDTO;
	}


	public void setListePaiementsDTO(List<PaiementContratDto> listePaiementsDTO) {
		this.listePaiementsDTO = listePaiementsDTO;
	}


	public boolean isEtatAvance() {
		return etatAvance;
	}


	public void setEtatAvance(boolean etatAvance) {
		this.etatAvance = etatAvance;
	}


	public Boolean getStatutContrat() {
		return statutContrat;
	}


	public void setStatutContrat(Boolean statutContrat) {
		this.statutContrat = statutContrat;
	}
		
}
