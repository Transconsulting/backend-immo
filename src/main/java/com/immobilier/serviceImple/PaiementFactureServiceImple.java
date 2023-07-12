package com.immobilier.serviceImple;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
  
import com.immobilier.dto.PaiementFactureDto;
import com.immobilier.mapper.Mapper;
import com.immobilier.model.CommandeClient; 
import com.immobilier.model.ModePaiement; 
import com.immobilier.model.PaiementFacture;
import com.immobilier.repository.CommandeClientRepository; 
import com.immobilier.repository.ModePaiementRepository;
import com.immobilier.repository.PaiementFactureRepository; 
import com.immobilier.service.PaiementFactureService; 

@Service
public class PaiementFactureServiceImple implements PaiementFactureService {
	@Autowired
	ModePaiementRepository modePaiementRepository;
	@Autowired
	PaiementFactureRepository paiementFactureRepository;
	@Autowired
	CommandeClientRepository commandeClientRepository;

	@Override
	public PaiementFactureDto add(PaiementFactureDto dto) {
		PaiementFactureDto response=new PaiementFactureDto();
		if (dto==null) {
			response.setCode(305);
			response.setTitre("Paiement");
			response.setStatut("Error");
			response.setDescription("Veuillez renseigner les champs concerné au paiement");
			return response;
		}
		
		CommandeClient cmdClient=commandeClientRepository.getById(dto.getUuidCommande()); 
		if (cmdClient==null) {
			response.setCode(305);
			response.setTitre("Paiement");
			response.setStatut("Error");
			response.setDescription("La commande a regler n'a pas été trouver");
			response.setUuidCommande(dto.getUuidCommande());
			response.setMontant(dto.getMontant());
			return response;
		}
		
		if (cmdClient.getMontantCmd()<cmdClient.getPayer()+dto.getMontant()) {
			response.setCode(305);
			response.setTitre("Paiement");
			response.setStatut("Error");
			response.setDescription("Le montant saisie est supérieur au reste a payé");
			return response;
		}
		
		ModePaiement modePaiement=modePaiementRepository.getById(dto.getUuidModePaiement()); 
		if (modePaiement==null) {
			response.setCode(305);
			response.setTitre("Paiement");
			response.setStatut("Error");
			response.setDescription("Ce mode de paiement n'a pas été trouver");
			return response;
		}
		
		//Modifier montant payé du contrat
		cmdClient.setPayer(cmdClient.getPayer()+dto.getMontant());
		commandeClientRepository.save(cmdClient);
				
		PaiementFacture paiement=paiementFactureRepository.save(Mapper.toPaiementFacture(dto,cmdClient,modePaiement));
		response=Mapper.toPaiementFactureDTO(paiement);
		response.setCode(200);
		response.setTitre("Paiement");
		response.setStatut("Success");
		response.setDescription("Le paiement a bien reussi");
		
		return response;
	}

	@Override
	public PaiementFactureDto update(PaiementFactureDto dto, String uuid) {
		PaiementFactureDto response=new PaiementFactureDto();
		if (dto==null) {
			response.setCode(305);
			response.setTitre("Paiement");
			response.setStatut("Error");
			response.setDescription("Veuillez renseigner les champs concerné au paiement");
			return response;
		}
		
		CommandeClient cmdClient=commandeClientRepository.getById(dto.getUuidCommande()); 
		if (cmdClient==null) {
			response.setCode(305);
			response.setTitre("Paiement");
			response.setStatut("Error");
			response.setDescription("Le commande a regler n'a pas été trouver");
			return response;
		}
		
		ModePaiement modePaiement=modePaiementRepository.getById(dto.getUuidModePaiement()); 
		if (modePaiement==null) {
			response.setCode(305);
			response.setTitre("Paiement");
			response.setStatut("Error");
			response.setDescription("Le mode de paiement n'a pas été trouver");
			return response;
		}
		dto.setUuid(uuid);
		PaiementFacture paiement=paiementFactureRepository.save(Mapper.toPaiementFacture(dto,cmdClient,modePaiement));
		response=Mapper.toPaiementFactureDTO(paiement);
		response.setCode(200);
		response.setTitre("Paiement");
		response.setStatut("Success");
		response.setDescription("Le montant payer a été modifier");
		
		return response;
	}

	@Override
	public List<PaiementFactureDto> findAll() {
		List<PaiementFacture> liste = paiementFactureRepository.findAll();  
		List<PaiementFactureDto> listeDTO = new ArrayList<>();
		liste.forEach(el -> listeDTO.add(Mapper.toPaiementFactureDTO(el)));
		return listeDTO;
	}

	@Override
	public PaiementFactureDto getByUuid(String uuid) {
		PaiementFacture paiement=paiementFactureRepository.getById(uuid);
		return Mapper.toPaiementFactureDTO(paiement);
	}

	@Override
	public void delete(String uuid) {
		paiementFactureRepository.deleteById(uuid);	
	}

	@Override
	public List<PaiementFactureDto> getPaiementByCommande(String uuidCommande) {
		List<PaiementFacture> liste = paiementFactureRepository.getPaiementByCommande(uuidCommande);  
		List<PaiementFactureDto> listeDTO = new ArrayList<>();
		liste.forEach(el -> listeDTO.add(Mapper.toPaiementFactureDTO(el)));
		return listeDTO;
	}
}
