package com.immobilier.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Columns;

import com.immobilier.enumeration.StatutDomaine;

@Entity
public class ParcelleAppartemnt extends AbstractDomainClass{
	
	private String numero;
	private double prix;
	private Integer caution;
	private String avance;
	private double fraisAgence;
	@Enumerated(EnumType.STRING)
	private StatutDomaine statut;
	@Column(name = "description", columnDefinition = "text" )
	private String appDescription;
	
	@ManyToOne
	@JoinColumn(name = "uuidDomaine") 
	private Domaine domaine;
	
	@OneToMany(mappedBy = "parcelleAppartemnt", fetch = FetchType.LAZY)
	private List<ParcelleApartemntDetail> lstparcelleApartemntDetail;
	
	@OneToMany(mappedBy = "parcelleAppartemnt", fetch = FetchType.LAZY)
	private List<ContratDetail> listeContratDetail;
	
	@OneToMany(mappedBy = "parcelleAppartemnt", fetch = FetchType.LAZY)
	private List<ParcelleAppartemntImage> parcelleAppartemntImage;
	@OneToMany(mappedBy = "parcelleAppartemnt", fetch = FetchType.LAZY)
	private List<ParcelleAppartementVideo> parcelleAppartementVideo;
	
	@OneToMany(mappedBy = "parcelleAppartemnt", fetch = FetchType.LAZY)
	private List<Interese> interese;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Domaine getDomaine() {
		return domaine;
	}

	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}

	public StatutDomaine getStatut() {
		return statut;
	}

	public void setStatut(StatutDomaine statut) {
		this.statut = statut;
	}

	public List<ParcelleApartemntDetail> getLstparcelleApartemntDetail() {
		return lstparcelleApartemntDetail;
	}

	public void setLstparcelleApartemntDetail(List<ParcelleApartemntDetail> lstparcelleApartemntDetail) {
		this.lstparcelleApartemntDetail = lstparcelleApartemntDetail;
	}

	public List<ContratDetail> getListeContratDetail() {
		return listeContratDetail;
	}

	public void setListeContratDetail(List<ContratDetail> listeContratDetail) {
		this.listeContratDetail = listeContratDetail;
	}

	 
	public Integer getCaution() {
		return caution;
	}

	public void setCaution(Integer caution) {
		this.caution = caution;
	}

	public String getAvance() {
		return avance;
	}

	public void setAvance(String avance) {
		this.avance = avance;
	}

	public double getFraisAgence() {
		return fraisAgence;
	}

	public void setFraisAgence(double fraisAgence) {
		this.fraisAgence = fraisAgence;
	}

	public List<ParcelleAppartemntImage> getParcelleAppartemntImage() {
		return parcelleAppartemntImage;
	}

	public void setParcelleAppartemntImage(List<ParcelleAppartemntImage> parcelleAppartemntImage) {
		this.parcelleAppartemntImage = parcelleAppartemntImage;
	}

	public List<Interese> getInterese() {
		return interese;
	}

	public void setInterese(List<Interese> interese) {
		this.interese = interese;
	}

	public String getAppDescription() {
		return appDescription;
	}

	public void setAppDescription(String appDescription) {
		this.appDescription = appDescription;
	}

	public List<ParcelleAppartementVideo> getParcelleAppartementVideo() {
		return parcelleAppartementVideo;
	}

	public void setParcelleAppartementVideo(List<ParcelleAppartementVideo> parcelleAppartementVideo) {
		this.parcelleAppartementVideo = parcelleAppartementVideo;
	}

	
	
}
