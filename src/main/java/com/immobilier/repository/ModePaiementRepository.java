package com.immobilier.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.immobilier.model.ModePaiement;

public interface ModePaiementRepository extends JpaRepository<ModePaiement, String> {
	ModePaiement findByLibelle(String modePaiement);

}
