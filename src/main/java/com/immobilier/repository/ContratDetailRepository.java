package com.immobilier.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query; 
import org.springframework.transaction.annotation.Transactional;

import com.immobilier.model.ContratDetail;

@Transactional
public interface ContratDetailRepository extends JpaRepository<ContratDetail, String> {
	
	@Modifying
	@Query("Delete from ContratDetail a where a.contrat.uuid=?1")
	void deleteByUuidContrat( String uuidContrat);
	
	@Query("Select a from ContratDetail a where a.contrat.uuid=?1")
	List<ContratDetail> getDetailByContrat(String uuidContrat);

}
