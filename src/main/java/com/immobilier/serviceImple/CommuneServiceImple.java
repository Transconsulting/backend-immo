package com.immobilier.serviceImple;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 

import com.immobilier.dto.CommuneDto; 
import com.immobilier.mapper.Mapper;
import com.immobilier.model.Commune; 
import com.immobilier.model.Ville;
import com.immobilier.repository.CommuneRepository;
import com.immobilier.repository.VilleRepository;
import com.immobilier.service.CommuneService;
 
@Service
public class CommuneServiceImple implements CommuneService {
	
	@Autowired
	CommuneRepository communeRepository;
	@Autowired
	VilleRepository villeRepository;

	@Override
	public CommuneDto addCommune(CommuneDto communedto) {
		CommuneDto response=new CommuneDto();
		if (communedto==null) {
		    response.setCode(305);
		    response.setTitre("Communne");
		    response.setDescription("Le nom de la commune n'a pas été renseigner");
		    response.setStatut("Error");
			return response;
		}
		
		Commune commune=communeRepository.findByNomCommuneAndVilleUuid(communedto.getLibelle(),communedto.getUuidVile());
		if (commune!=null) {
			response.setCode(305);
		    response.setTitre("Communne");
		    response.setDescription("Cette commune a été déjà enregister dans la ville selectionnée");
		    response.setStatut("Error");
			return response;
		} 
		Ville ville = villeRepository.getById(communedto.getUuidVile());
		if (ville==null) {
			response.setCode(305);
		    response.setTitre("Ville");
		    response.setDescription("La ville sélectionnée n'a pas été trouver dans la base des données");
		    response.setStatut("Error");
			return response;
		}
		
		commune = new Commune(); 
		commune.setNomCommune(communedto.getLibelle());
		commune.setVille(ville); 
		
		response=Mapper.toCommuneDto(communeRepository.save(commune));
		response.setCode(200);
	    response.setTitre("Commune");
	    response.setDescription("Le nom de la commune a été bien enregistrer");
	    response.setStatut("Success");
		return response;
	}

	@Override
	public CommuneDto updateCommune(CommuneDto communedto, String uuid) {
		CommuneDto response=new CommuneDto();
		
		if (communedto==null || uuid.isEmpty()) {
		    response.setCode(305);
		    response.setTitre("Commune");
		    response.setDescription("Le nom de la commune n'a pas été renseigner");
		    response.setStatut("Error");
			return response;
		}
		Commune commune=communeRepository.getById(uuid);
		if (commune==null) {
			response.setCode(305);
		    response.setTitre("Commune");
		    response.setDescription("Cette commune n'a pas été trouver dans la base de données");
		    response.setStatut("Error");
			return response;
		} 
				
		Ville ville = villeRepository.getById(communedto.getUuidVile());
		if (ville==null) {
			response.setCode(305);
		    response.setTitre("Commune");
		    response.setDescription("La ville sélectionnée n'a pas été trouver dans la base des données");
		    response.setStatut("Error");
			return response;
		} 
		
		commune = new Commune(); 
		commune.setNomCommune(communedto.getLibelle());
		commune.setVille(ville);
		
		response=Mapper.toCommuneDto(communeRepository.save(commune));
		response.setCode(200);
	    response.setTitre("Commune");
	    response.setDescription("Le nom de la commune a été bien enregistrer");
	    response.setStatut("Success");
		return response;
	}

	@Override
	public List<CommuneDto> findAllCommune() {
		// TODO Auto-generated method stub
		List<Commune> communes = communeRepository.findAll();
		List<CommuneDto> communeDtos = new ArrayList<CommuneDto>();
		communes.forEach(commune -> communeDtos.add(Mapper.toCommuneDto(commune)));
		return communeDtos;
	}

	@Override
	public CommuneDto getByUuid(String uuid) {
		CommuneDto response=new CommuneDto();
		if (uuid.isEmpty()) {
		    response.setCode(305);
		    response.setTitre("Commune");
		    response.setDescription("L'identifiant de la commune ne peut être null");
		    response.setStatut("Error");
			return response;
		} 
		return Mapper.toCommuneDto(communeRepository.getById(uuid));
	}

	@Override
	public void deleteCommune(String uuid) {
		CommuneDto response=new CommuneDto();
		if (uuid.isEmpty()) {
		    response.setCode(305);
		    response.setTitre("Commune");
		    response.setDescription("L'identifiant de la commune ne peut être null");
		    response.setStatut("Error");
			return ;
		}
		communeRepository.deleteById(uuid);
	}

	@Override
	public List<CommuneDto> findAllByVilleUuid(String uuidVille) {
		List<Commune> liste = communeRepository.findAllByVilleUuid(uuidVille);
		final List<CommuneDto> listeDto = new ArrayList<>();
		liste.forEach(el -> listeDto.add(Mapper.toCommuneDto(el)));
		return listeDto;
	}

	@Override
	public CommuneDto findByNomCommuneAndVilleUuid(String commune, String uuidVille) {
		return Mapper.toCommuneDto(communeRepository.findByNomCommuneAndVilleUuid(commune, uuidVille));
	}

}
