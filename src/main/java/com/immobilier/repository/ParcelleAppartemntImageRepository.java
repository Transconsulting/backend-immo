package com.immobilier.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.immobilier.model.ParcelleAppartemntImage;

public interface ParcelleAppartemntImageRepository extends JpaRepository<ParcelleAppartemntImage, String> {
	
	//@Query("Select p from ParcelleAppartemntImage p where p.parcelleAppartemnt.uuid=:x")
	
	@Query("Select p from ParcelleAppartemntImage p where p.parcelleAppartemnt.uuid=:x")
	List<ParcelleAppartemntImage> findAllImageByParcelleAppartemnt(@Param("x") String uuidParcelleAppartemnt);

}