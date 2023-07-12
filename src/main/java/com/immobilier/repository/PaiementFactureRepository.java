package com.immobilier.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.immobilier.model.PaiementFacture;

public interface PaiementFactureRepository extends JpaRepository<PaiementFacture, String> {
	
	@Query("Select a from PaiementFacture a where a.commandeClient.uuid=:x")
	public List<PaiementFacture> getPaiementByCommande(@Param("x") String uuidContrat);
	
}
