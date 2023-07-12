package com.immobilier.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.immobilier.model.ParcelleApartemntDetail;

public interface ParcelleApartemntDetailRepository extends JpaRepository<ParcelleApartemntDetail, String> {

	@Query("Select p from ParcelleApartemntDetail p where p.parcelleAppartemnt.uuid=:x")
	public List<ParcelleApartemntDetail> getParcelleApartemntDetail(@Param("x") String uuidParcelleApartement);
}
