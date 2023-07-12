package com.immobilier.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.immobilier.model.Proprietaire;

public interface ProprietaireRepository extends JpaRepository<Proprietaire, String>{
 
	public Proprietaire findByTel(String tel);
	public long count();
}
