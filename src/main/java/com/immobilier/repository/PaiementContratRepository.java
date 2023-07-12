package com.immobilier.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.immobilier.model.PaiementContrat;

public interface PaiementContratRepository extends JpaRepository<PaiementContrat, String> {
	
	@Query("Select a from PaiementContrat a where a.contrat.uuid=:x")
	public List<PaiementContrat> getPaiementByContrat(@Param("x") String uuidContrat);
	
}
