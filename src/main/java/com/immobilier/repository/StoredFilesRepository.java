package com.immobilier.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.immobilier.model.StoredFile;







public interface StoredFilesRepository extends JpaRepository<StoredFile, String> {

	StoredFile findByUuid(String id);
	




	
}
