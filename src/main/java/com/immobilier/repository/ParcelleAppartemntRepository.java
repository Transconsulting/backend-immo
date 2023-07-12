package com.immobilier.repository;
 
import java.util.List;
 
import org.springframework.data.jpa.repository.JpaRepository; 

import com.immobilier.enumeration.StatutDomaine; 
import com.immobilier.model.ParcelleAppartemnt;

public interface ParcelleAppartemntRepository extends JpaRepository<ParcelleAppartemnt, String>{
	public ParcelleAppartemnt findByNumeroAndDomaineUuid(String numero,String uuidDomaine);
	public Integer countByStatut(StatutDomaine statut);
	public List<ParcelleAppartemnt> findAllByStatutOrderByDateCreatedDesc(StatutDomaine statut);
	public List<ParcelleAppartemnt> findAllByStatutAndDomaineUuid(StatutDomaine statut,String uuidDommaine);
	public List<ParcelleAppartemnt> findAllByDomaineUuid(String uuidDomaine);
	
	//client
	public List<ParcelleAppartemnt> findAllByStatutAndDomaineLibelleStartingWith(StatutDomaine statut,String titre); 
	public List<ParcelleAppartemnt> findAllByStatutAndDomaineAgentNomCompletContaining(StatutDomaine statut,String agent);
	//public List<ParcelleAppartemnt> findAllByDomaineByTypeAnnonce(TypeAnnonce typeAnnonce);
	
}
