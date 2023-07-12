package com.immobilier.serviceImple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.immobilier.dto.ParcelleAppartemntDto;
import com.immobilier.enumeration.StatutDomaine;
import com.immobilier.mapper.Mapper; 
import com.immobilier.model.Domaine; 
import com.immobilier.model.ParcelleAppartemnt;
import com.immobilier.repository.ContratDetailRepository;
import com.immobilier.repository.DomaineRepository; 
import com.immobilier.repository.ParcelleAppartemntRepository;
import com.immobilier.service.ParcelleAppartemntService;

@Service
public class ParcelleAppartemntServiceImple implements ParcelleAppartemntService{
	
	@Autowired
	ParcelleAppartemntRepository parcelleAppartemntRepository;
	@Autowired
	DomaineRepository domaineRepository;
	@Autowired
	ContratDetailRepository contratDetailRepository;

	@Override
	public ParcelleAppartemntDto saveParcelleAppartemnt(ParcelleAppartemntDto parcelleAppartemntDto) { 
		ParcelleAppartemntDto response=new ParcelleAppartemntDto();
		
		Domaine domaine = domaineRepository.getById(parcelleAppartemntDto.getUuidDomaine());
		if (domaine==null) {
			response.setCode(305);
			response.setTitre("Domaine introuvale");
			response.setStatut("Error");
			response.setDescription("Ce domaine n'a pas été trouver dans la base des données");
			return response;
		}
		
		ParcelleAppartemnt app=parcelleAppartemntRepository.findByNumeroAndDomaineUuid(parcelleAppartemntDto.getNumero(),parcelleAppartemntDto.getUuidDomaine());
		if (app!=null) {
			response.setCode(305);
			response.setTitre("Numéro...");
			response.setStatut("Error");
			response.setDescription("Ce numéro a été déjà ajouter avec ce domaine");
			return response;
		}
		
		ParcelleAppartemnt parcelleAppartemnt = new ParcelleAppartemnt();
		parcelleAppartemnt.setNumero(parcelleAppartemntDto.getNumero());
		parcelleAppartemnt.setPrix(parcelleAppartemntDto.getPrix());
		parcelleAppartemnt.setDomaine(domaine);
		parcelleAppartemnt.setAppDescription(parcelleAppartemntDto.getAppDescription());
		parcelleAppartemnt.setStatut(parcelleAppartemntDto.getStatutDomaine());
		parcelleAppartemnt.setAvance(parcelleAppartemntDto.getAvance());
		parcelleAppartemnt.setCaution(parcelleAppartemntDto.getCaution());
		parcelleAppartemnt.setFraisAgence(parcelleAppartemntDto.getFraisAgence());
		ParcelleAppartemnt parcelleAppartemntSave=parcelleAppartemntRepository.save(parcelleAppartemnt);
		
		response=Mapper.toParcelleAppartemntDto(parcelleAppartemntSave);
		response.setCode(200);
		response.setTitre("Modification");
		response.setStatut("Success");
		response.setDescription("L'appartement a été enregistrer avec succès");
		return response;
	}

	@Override
	public ParcelleAppartemntDto updateParcelleAppartemnt(ParcelleAppartemntDto dto, String uuid) {
		ParcelleAppartemntDto response=new ParcelleAppartemntDto();
		
		Domaine domaine = domaineRepository.getById(dto.getUuidDomaine());
		if (domaine==null) {
			response.setCode(305);
			response.setTitre("Domaine introuvale");
			response.setStatut("Error");
			response.setDescription("Ce domaine n'a pas été trouver dans la base des données");
			return response;
		}
		
		Optional<ParcelleAppartemnt> appOp=parcelleAppartemntRepository.findById(uuid);
		if (!appOp.isPresent()) {
			response.setCode(305);
			response.setTitre("Appartement introuvable...");
			response.setStatut("Error");
			response.setDescription("Cet appartement n'a pas été trouver dans la base des données");
			return response;
		}
		
		ParcelleAppartemnt app=appOp.get();
		app.setNumero(dto.getNumero());
		app.setPrix(dto.getPrix());
		app.setStatut(dto.getStatutDomaine());
		app.setDomaine(domaine);
		app.setAvance(dto.getAvance());
		app.setCaution(dto.getCaution());
		app.setFraisAgence(dto.getFraisAgence()); 
		app.setAppDescription(dto.getAppDescription());
		ParcelleAppartemnt parcelleAppartemntUpdate=parcelleAppartemntRepository.save(app);
		response=Mapper.toParcelleAppartemntDto(parcelleAppartemntUpdate);
		response.setCode(200);
		response.setTitre("Modification");
		response.setStatut("Success");
		response.setDescription("L'appartement a été modifier avec succès");
		return response;
	}

	@Override
	public ParcelleAppartemntDto getByuuid(String uuid) {  
		Optional<ParcelleAppartemnt> parcelleAppartemnt = parcelleAppartemntRepository.findById(uuid);
		if (!parcelleAppartemnt.isPresent()) {
			return new ParcelleAppartemntDto();
		}
		return Mapper.toParcelleAppartemntDto(parcelleAppartemnt.get());
	}

	@Override
	public void deleteParcelleAppartemnt(String uuid) { 
		parcelleAppartemntRepository.deleteById(uuid);
	}

	@Override
	public List<ParcelleAppartemntDto> findAllParcelleAppartemnt() { 
		List<ParcelleAppartemnt> parcelleAppartemnts = parcelleAppartemntRepository.findAll();
		List<ParcelleAppartemntDto> parcelleAppartemntDtos = new ArrayList<ParcelleAppartemntDto>();
		parcelleAppartemnts.forEach(parcelleAppartement -> parcelleAppartemntDtos.add(Mapper.toParcelleAppartemntDto(parcelleAppartement)));
		return parcelleAppartemntDtos;
	}

	@Override
	public Integer getTotalByStatut(StatutDomaine statut) { 
		return parcelleAppartemntRepository.countByStatut(statut);
	}

	@Override
	public List<ParcelleAppartemntDto> findAllByStatut(StatutDomaine statut) {
		List<ParcelleAppartemnt> parcelleAppartemnts = parcelleAppartemntRepository.findAllByStatutOrderByDateCreatedDesc (statut);
		List<ParcelleAppartemntDto> parcelleAppartemntDtos = new ArrayList<ParcelleAppartemntDto>();
		parcelleAppartemnts.forEach(parcelleAppartement -> parcelleAppartemntDtos.add(Mapper.toParcelleAppartemntDto(parcelleAppartement)));
		return parcelleAppartemntDtos;
	}

	@Override
	public List<ParcelleAppartemntDto> findAllByStatutAndDomaine(StatutDomaine statut, String uuidDommaine) {
		List<ParcelleAppartemnt> parcelleAppartemnts = parcelleAppartemntRepository.findAllByStatutAndDomaineUuid(statut, uuidDommaine);
		List<ParcelleAppartemntDto> parcelleAppartemntDtos = new ArrayList<ParcelleAppartemntDto>();
		parcelleAppartemnts.forEach(parcelleAppartement -> parcelleAppartemntDtos.add(Mapper.toParcelleAppartemntDto(parcelleAppartement)));
		return parcelleAppartemntDtos;
	}

	@Override
	public ParcelleAppartemntDto statutAppartementParcelle(StatutDomaine statut,String uuidParcelleApp) {
		ParcelleAppartemntDto response=new ParcelleAppartemntDto(); 
		if (StatutDomaine.AUCUN!=statut && StatutDomaine.ANNONCE!=statut ) {
			response.setCode(305);
			response.setTitre("Modification du statut");
			response.setStatut("Error");
			response.setDescription("Le statut de l'appartement ne peut être : Aucun ou une Annoce");
			return response;
		} 
		
		Optional<ParcelleAppartemnt> parcelleAppartementOp=parcelleAppartemntRepository.findById(uuidParcelleApp); 
		ParcelleAppartemnt parcelleAppartement=new ParcelleAppartemnt();
		if (!parcelleAppartementOp.isPresent()){ 
			response.setCode(305);
			response.setTitre("Modification du statut");
			response.setStatut("Error");
			response.setDescription("Cet appartement n'a pas été trouver dans la base de donnée");
			return response;
		}
		parcelleAppartement=parcelleAppartementOp.get();
		if (parcelleAppartement.getStatut()!=StatutDomaine.AUCUN && parcelleAppartement.getStatut()!=StatutDomaine.ANNONCE) {
			response.setCode(305);
			response.setTitre("Modification du statut");
			response.setStatut("Error");
			response.setDescription("Cet appartement appartient déjà dans un contrat");
			return response;
		}  
		parcelleAppartement.setStatut(statut);  
		parcelleAppartemntRepository.save(parcelleAppartement); 
		
		response=Mapper.toParcelleAppartemntDto(parcelleAppartement);
		response.setCode(200);
		response.setTitre("Modification du statut");
		response.setStatut("Success");
		response.setDescription("Le statut de l'appartement a été modifier avec succès"); 
		return response;
	}
	

}
