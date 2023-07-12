package com.immobilier.serviceImple;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.immobilier.dto.QuartierDto; 
import com.immobilier.mapper.Mapper;
import com.immobilier.model.Commune; 
import com.immobilier.model.Quartier; 
import com.immobilier.repository.CommuneRepository;
import com.immobilier.repository.QuartierRepository;
import com.immobilier.service.QuartierService;

@Service
public class QuartierServiceImple implements QuartierService{
	
	@Autowired
	QuartierRepository quartierRepository;
	@Autowired
	CommuneRepository communeRepository;
    
	@Override
	public QuartierDto addQuatier(QuartierDto quartierdto) {
		QuartierDto response=new QuartierDto();
		if (quartierdto==null) {
		    response.setCode(305);
		    response.setTitre("Quartier");
		    response.setDescription("Le nom du quartier n'a pas été renseigner");
		    response.setStatut("Error");
			return response;
		}
		
		Quartier quartier=quartierRepository.findByNomQuarierAndCommuneUuid(quartierdto.getLibelle(),quartierdto.getUuidCommune());
		if (quartier!=null) {
			response.setCode(305);
		    response.setTitre("Quartier");
		    response.setDescription("Ce quartier a été déjà enregister dans la commune selectionnée");
		    response.setStatut("Error");
			return response;
		} 
		Commune commune = communeRepository.getById(quartierdto.getUuidCommune());
		if (commune==null) {
			response.setCode(305);
		    response.setTitre("Commune");
		    response.setDescription("La commune sélectionnée n'a pas été trouver dans la base des données");
		    response.setStatut("Error");
			return response;
		}
		
		quartier = new Quartier(); 
		quartier.setNomQuartier(quartierdto.getLibelle());
		quartier.setCommune(commune); 
		response=Mapper.toQuartierDto(quartierRepository.save(quartier));
		response.setCode(200);
	    response.setTitre("Quartier");
	    response.setDescription("Le nom du quartier a été bien enregistrer");
	    response.setStatut("Success");
		return response;
	}

	@Override
	public QuartierDto updateQuatier(QuartierDto quartierdto, String uuid) {
		QuartierDto response=new QuartierDto();
		
		if (quartierdto==null || uuid.isEmpty()) {
		    response.setCode(305);
		    response.setTitre("Quartier");
		    response.setDescription("Le nom du quartier n'a pas été renseigner");
		    response.setStatut("Error");
			return response;
		}
		Quartier quartier=quartierRepository.getById(uuid);
		if (quartier==null) {
			response.setCode(305);
		    response.setTitre("Quartier");
		    response.setDescription("Ce quartier n'a pas été trouver dans la base de données");
		    response.setStatut("Error");
			return response;
		} 
				
		Commune commune = communeRepository.getById(quartierdto.getUuidCommune());
		if (commune==null) {
			response.setCode(305);
		    response.setTitre("Commune");
		    response.setDescription("La commune sélectionnée n'a pas été trouver dans la base des données");
		    response.setStatut("Error");
			return response;
		} 
		
		quartier = new Quartier(); 
		quartier.setNomQuartier(quartierdto.getLibelle());
		quartier.setCommune(commune); 
		
		response=Mapper.toQuartierDto(quartierRepository.save(quartier));
		response.setCode(200);
	    response.setTitre("Quartier");
	    response.setDescription("Le nom du quartier a été bien modifier");
	    response.setStatut("Success");
		return response;
	}

	@Override
	public List<QuartierDto> findAllQuatier() { 
		List<Quartier> quartiers = quartierRepository.findAll();
		List<QuartierDto> quartierDtos = new ArrayList<QuartierDto>();
		quartiers.forEach(quartier -> quartierDtos.add(Mapper.toQuartierDto(quartier)));
		return quartierDtos;
	}

	@Override
	public QuartierDto getByUuid(String uuid) {
		QuartierDto response=new QuartierDto();
		
		if ( uuid.isEmpty()) {
		    response.setCode(305);
		    response.setTitre("Quartier");
		    response.setDescription("L'identifiant du quartier ne peut pas être null");
		    response.setStatut("Error");
			return response;
		}
		Quartier quartier = new Quartier();
		quartier = quartierRepository.getById(uuid);
		return Mapper.toQuartierDto(quartier);
	}

	@Override
	public void deleteQuatier(String uuid) {
		QuartierDto response=new QuartierDto(); 
		if (uuid.isEmpty()) {
		    response.setCode(305);
		    response.setTitre("Quartier");
		    response.setDescription("L'identifiant du quartier ne peut pas être null");
		    response.setStatut("Error");
			return ;
		}
		quartierRepository.deleteById(uuid);
	}

	@Override
	public List<QuartierDto> findAllByCommuneUuid(String uuidCommune) {
		List<Quartier> liste = quartierRepository.findAllByCommuneUuid(uuidCommune);
		final List<QuartierDto> listeDto = new ArrayList<>();
		liste.forEach(el -> listeDto.add(Mapper.toQuartierDto(el)));
		return listeDto;
	}

	@Override
	public QuartierDto findByQuartierAndCommune(String quartier, String uuidCommune){
		return Mapper.toQuartierDto(quartierRepository.findByNomQuarierAndCommuneUuid(quartier, uuidCommune));
	}

}
