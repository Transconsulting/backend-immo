package com.immobilier.service;
 
import java.util.List;
  

public interface EnumerationService {

	List<String> listeTypeAnnonce();
	List<String> listeStatutDomaine();
	List<String> listeTypeAgent();
	List<String> listeTypeDomaine();
	List<String> listeTypeContrat();
	List<String> listeTypeDeTraveaux();
}
