package com.immobilier.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
 
import com.immobilier.model.DetailCommandeClient;

@Transactional
public interface DetailCommandeClientRepository extends JpaRepository<DetailCommandeClient, String>{
		
	@Modifying
	@Query("Delete from DetailCommandeClient a where a.commandeClient.uuid=?1")
	void deleteDetailCommandeByIdCmd(String uuidCmd);
	
	@Query("Select a from DetailCommandeClient a where a.commandeClient.uuid=?1")
	List<DetailCommandeClient> getDetailCommandeByIdCmd(String uuidCmd);
}
