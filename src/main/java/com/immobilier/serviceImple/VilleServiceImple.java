package com.immobilier.serviceImple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 

import com.immobilier.dto.VilleDto;
import com.immobilier.mapper.Mapper;
import com.immobilier.model.Ville;
import com.immobilier.repository.VilleRepository;
import com.immobilier.service.VilleService;


@Service
public class VilleServiceImple implements VilleService{
	
	@Autowired
	VilleRepository villeRepository;

	@Override
	public VilleDto addVille(VilleDto villedto) {
		VilleDto response=new VilleDto();
		if (villedto==null) {
		    response.setCode(305);
		    response.setTitre("Ville");
		    response.setDescription("La ville n'a pas été renseigner");
		    response.setStatut("Error");
			return response;
		}
		
		Ville ville=villeRepository.findByNomVille(villedto.getLibelle());
		if (ville!=null) {
			response.setCode(305);
		    response.setTitre("Ville");
		    response.setDescription("Cette ville a été déjà enregistrer");
		    response.setStatut("Error");
			return response;
		} 
		ville=new Ville();
		ville.setNomVille(villedto.getLibelle()); 
		
		response=Mapper.toVilleDto(villeRepository.save(ville));
				
		response.setCode(200);
	    response.setTitre("Ville");
	    response.setDescription("Cette ville a été bien enregistrer");
	    response.setStatut("Success");
	    
		return response;
	}

	@Override
	public VilleDto updateVille(VilleDto villedto, String uuid) {
		VilleDto response=new VilleDto();
		if (villedto==null || uuid.isEmpty()) {
		    response.setCode(305);
		    response.setTitre("Ville");
		    response.setDescription("La ville n'a pas été renseigner");
		    response.setStatut("Error");
			return response;
		} 
		Optional<Ville> villeOp = villeRepository.findById(uuid);
		if (!villeOp.isPresent()) {
			response.setCode(305);
		    response.setTitre("Ville");
		    response.setDescription("Cette ville n'a pas été trouver dans la base des données");
		    response.setStatut("Error");
			return response;
		}
		
		Ville ville = villeOp.get();
		ville.setNomVille(villedto.getLibelle()); 
		
		response=Mapper.toVilleDto(villeRepository.save(ville));
		response.setCode(200);
	    response.setTitre("Ville");
	    response.setDescription("Cette ville a été bien modifier");
	    response.setStatut("Success");
		return response;
	}

	@Override
	public List<VilleDto> findAllVille() {
		// TODO Auto-generated method stub
		List<Ville> villes = villeRepository.findAll();
		List<VilleDto> villeDtos = new ArrayList<VilleDto>();
		villes.forEach(ville -> villeDtos.add(Mapper.toVilleDto(ville)));
		return villeDtos;
	}

	@Override
	public VilleDto getByUuid(String uuid) {
		VilleDto response=new VilleDto();
		if (uuid.isEmpty()) {
		    response.setCode(305);
		    response.setTitre("Ville");
		    response.setDescription("L'identifiant de la ville ne peut être null");
		    response.setStatut("Error");
			return response;
		} 
		Ville ville = new Ville();
		ville = villeRepository.getById(uuid);
		return Mapper.toVilleDto(ville);
	}

	@Override
	public void deleteVille(String uuid) {
		VilleDto response=new VilleDto();
		if (uuid.isEmpty()) {
		    response.setCode(305);
		    response.setTitre("Ville");
		    response.setDescription("L'identifiant de la ville ne peut être null");
		    response.setStatut("Error");
			return;
		} 
		villeRepository.deleteById(uuid);
	}

	@Override
	public VilleDto findByVille(String ville) { 
		return Mapper.toVilleDto(villeRepository.findByNomVille(ville));
	}

}
