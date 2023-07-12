package com.immobilier.dto;

public class MaterielDto extends ResponseDto {

	private String uuid;
	private String libelle;
	private String description;
	private double prix;
	private byte photo1;
	private byte photo2;
	private byte photo3;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public byte getPhoto1() {
		return photo1;
	}
	public void setPhoto1(byte photo1) {
		this.photo1 = photo1;
	}
	public byte getPhoto2() {
		return photo2;
	}
	public void setPhoto2(byte photo2) {
		this.photo2 = photo2;
	}
	public byte getPhoto3() {
		return photo3;
	}
	public void setPhoto3(byte photo3) {
		this.photo3 = photo3;
	}
	
	
}
