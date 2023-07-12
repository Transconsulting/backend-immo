package com.immobilier.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.immobilier.model.Contrat;

public interface ContratRepository extends JpaRepository<Contrat, String> {
	List<Contrat> findAllByClientUuid(String uuid);
}