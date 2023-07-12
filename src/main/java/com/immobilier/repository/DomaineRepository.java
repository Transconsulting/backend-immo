package com.immobilier.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.immobilier.enumeration.StatutDomaine;
import com.immobilier.model.Domaine;

public interface DomaineRepository extends JpaRepository<Domaine, String>{
	List<Domaine> findAllByProprietaireUuid(String uuid);
	List<Domaine> findAllByStatut(StatutDomaine statut);
	List<Domaine> findAllByStatutAndProprietaireUuid(StatutDomaine statut,String uuidProprietaire);
}
