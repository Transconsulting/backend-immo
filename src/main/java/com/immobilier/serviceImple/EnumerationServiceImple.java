package com.immobilier.serviceImple;

import java.util.ArrayList; 
import java.util.List;

import org.springframework.stereotype.Service; 

import com.immobilier.enumeration.TypeAnnonce;
import com.immobilier.enumeration.TypeContrat;
import com.immobilier.enumeration.StatutDomaine;
import com.immobilier.enumeration.TypeAgent;
import com.immobilier.enumeration.TypeDomaine;
import com.immobilier.enumeration.TypeTraveaux;
import com.immobilier.service.EnumerationService; 
 
@Service
public class EnumerationServiceImple implements EnumerationService {

	@Override
	public List<String> listeTypeAnnonce() { 
		List<String> liste = new ArrayList<>(); 
		List<TypeAnnonce> listeEnum=TypeAnnonce.getValues();
		for (TypeAnnonce a: listeEnum) {
			liste.add(a.name());
		}
		return liste;
	}

	@Override
	public List<String> listeStatutDomaine() { 
		List<String> liste = new ArrayList<>(); 
		List<StatutDomaine> listeEnum=StatutDomaine.getValues();
		for (StatutDomaine a: listeEnum) {
			liste.add(a.name());
		}
		return liste;
	}

	@Override
	public List<String> listeTypeAgent() { 
		List<String> liste = new ArrayList<>(); 
		List<TypeAgent> listeEnum=TypeAgent.getValues();
		for (TypeAgent a: listeEnum) { 
			liste.add(a.name());
		}
		return liste;
	}

	@Override
	public List<String> listeTypeDomaine() { 
		List<String> liste = new ArrayList<>(); 
		List<TypeDomaine> listeEnum=TypeDomaine.getValues();
		for (TypeDomaine a: listeEnum) {
			liste.add(a.name());
		}
		return liste;
	}

	@Override
	public List<String> listeTypeDeTraveaux() {
		List<String> liste = new ArrayList<>(); 
		List<TypeTraveaux> listeEnum=TypeTraveaux.getValues();
		for (TypeTraveaux a: listeEnum) {
			liste.add(a.name());
		}
		return liste;
	}

	@Override
	public List<String> listeTypeContrat() {
		List<String> liste = new ArrayList<>(); 
		List<TypeContrat> listeEnum=TypeContrat.getValues();
		for (TypeContrat a: listeEnum) {
			liste.add(a.name());
		}
		return liste;
	}

}
