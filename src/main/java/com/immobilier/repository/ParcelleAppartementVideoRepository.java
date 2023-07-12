package com.immobilier.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.immobilier.model.ParcelleAppartementVideo; 

public interface ParcelleAppartementVideoRepository extends JpaRepository<ParcelleAppartementVideo, String> {
	
	//@Query("Select p from ParcelleAppartemntImage p where p.parcelleAppartemnt.uuid=:x")
	@Query("Select p from ParcelleAppartementVideo p where p.parcelleAppartemnt.uuid=:x")
	List<ParcelleAppartementVideo> findAllVideoByParcelleAppartemnt(@Param("x") String uuidParcelleAppartemnt);

}