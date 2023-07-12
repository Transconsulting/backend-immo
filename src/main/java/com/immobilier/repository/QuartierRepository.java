package com.immobilier.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
 
import com.immobilier.model.Quartier;

public interface QuartierRepository extends JpaRepository<Quartier, String> {
	Quartier findByNomQuarierAndCommuneUuid(String quartier,String uuidCommune);
	List<Quartier> findAllByCommuneUuid(String uuid);
}
