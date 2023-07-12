package com.immobilier.serviceImple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.immobilier.dto.ProprietaireDto;
import com.immobilier.mapper.Mapper;
import com.immobilier.model.Proprietaire;
import com.immobilier.repository.ParcelleAppartemntRepository;
import com.immobilier.repository.ProprietaireRepository;
import com.immobilier.service.ProprietaireService;

@Service
public class ProprietaireServiceImple implements ProprietaireService{
	
	@Autowired
	ProprietaireRepository proprietaireRepository;
	@Autowired
	ParcelleAppartemntRepository parcelleAppartemntRepository;
	

	@Override
	public ProprietaireDto saveProprietaire(ProprietaireDto proprietaireDto) { 
		ProprietaireDto responsedto = new ProprietaireDto();
		if(proprietaireDto==null) {
			responsedto.setCode(305);
			responsedto.setTitre("CONTROLE SAISIE");
			responsedto.setStatut("Error");
			responsedto.setDescription(" SAISISSEZ LES INFO PROPRIETAIRE !");
			return responsedto;
		}
		Proprietaire proprietaire = proprietaireRepository.findByTel(proprietaireDto.getTel());
		if(proprietaire!=null){ 
			responsedto.setCode(305);
			responsedto.setTitre("CONTROLE DOUBLON");
			responsedto.setStatut("Error");
			responsedto.setDescription(" CE NUMERO TELEPHONE PROPRIETAIRE EXISTE DEJA !"); 
			return responsedto;
		}
		proprietaire = new Proprietaire();
		proprietaire.setNom(proprietaireDto.getNom());
		proprietaire.setPrenoms(proprietaireDto.getPrenoms());
		proprietaire.setDateNaiss(proprietaireDto.getDateNaiss());
		proprietaire.setVille(proprietaireDto.getVille());
		proprietaire.setTel(proprietaireDto.getTel());
		proprietaire.setUuid(proprietaireDto.getUuid());
		proprietaire=proprietaireRepository.save(proprietaire);
		responsedto = Mapper.toProprietaireDto(proprietaire);
		responsedto.setCode(200);
		responsedto.setTitre("ENREGISTREMENT");
		responsedto.setStatut("CONFIRMATION");
		responsedto.setDescription("L'enregistrement a  bien reussi!");
		return responsedto;
	}

	@Override
	public ProprietaireDto updateProprietaire(ProprietaireDto proprietaireDto,String uuid) {
		ProprietaireDto responsedto = new ProprietaireDto();
		if(proprietaireDto==null) {
			responsedto.setCode(305);
			responsedto.setTitre("CONTROLE SAISIE");
			responsedto.setStatut("Error");
			responsedto.setDescription(" SAISISSEZ LES INFO PROPRIETAIRE !");
			return responsedto;
		}
		Optional<Proprietaire> proprietaireOp = proprietaireRepository.findById(uuid);
		if(proprietaireOp==null){ 
			responsedto.setCode(305);
			responsedto.setTitre("Propriétaire introuvable");
			responsedto.setStatut("Error");
			responsedto.setDescription("Le propriétaire à modifier n'a pas été trouver dans la base de données"); 
			return responsedto;
		}
		Proprietaire proprietaire = proprietaireOp.get(); 
		proprietaire.setNom(proprietaireDto.getNom());
		proprietaire.setPrenoms(proprietaireDto.getPrenoms());
		proprietaire.setDateNaiss(proprietaireDto.getDateNaiss());
		proprietaire.setVille(proprietaireDto.getVille());
		proprietaire.setTel(proprietaireDto.getTel());
		Proprietaire proprietaireUpdate=proprietaireRepository.save(proprietaire); 
		responsedto = Mapper.toProprietaireDto(proprietaireUpdate);
		responsedto.setCode(200);
		responsedto.setTitre("MODIFICATION");
		responsedto.setStatut("CONFIRMATION");
		responsedto.setDescription("La modification a  bien reussi!");
		return responsedto;
	}

	@Override
	public ProprietaireDto getByuuid(String uuid) { 
		Optional<Proprietaire> proprietaire = proprietaireRepository.findById(uuid);
		if (!proprietaire.isPresent()) {
			return new ProprietaireDto();
		}
		return Mapper.toProprietaireDto(proprietaire.get());
	}

	@Override
	public ProprietaireDto deleteProprietaire(String uuid) { 
		ProprietaireDto response=new ProprietaireDto();
		if (!parcelleAppartemntRepository.findAllByDomaineUuid(uuid).isEmpty()) {
			response.setCode(200);
			response.setTitre("Suppression Impossible...");
			response.setStatut("Error");
			response.setDescription("Impossible de supprimer un propriétaire qui a des habitations");
			return response;
		}
		proprietaireRepository.deleteById(uuid);
		response.setCode(200);
		response.setTitre("Suppression...");
		response.setStatut("Success");
		response.setDescription("La suppression a bien reussi");
		return response; 
	}

	@Override
	public List<ProprietaireDto> findAllProprietaire() {
		// TODO Auto-generated method stub
		List<Proprietaire> proprietaires = proprietaireRepository.findAll();
		List<ProprietaireDto> proprietaireDtos= new ArrayList<ProprietaireDto>();
		proprietaires.forEach(Proprietaire -> proprietaireDtos.add(Mapper.toProprietaireDto(Proprietaire)));
		return proprietaireDtos;
	}

	@Override
	public long getTotalProprietaire() {
		return proprietaireRepository.count();
	}

}
