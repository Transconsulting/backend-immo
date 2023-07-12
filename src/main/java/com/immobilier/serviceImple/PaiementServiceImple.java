package com.immobilier.serviceImple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.immobilier.dto.PaiementContratDto;
import com.immobilier.mapper.Mapper;
import com.immobilier.model.Contrat;
import com.immobilier.model.ModePaiement;
import com.immobilier.model.PaiementContrat;
import com.immobilier.repository.ContratRepository;
import com.immobilier.repository.ModePaiementRepository;
import com.immobilier.repository.PaiementContratRepository;
import com.immobilier.service.PaiementContratService;

@Service
public class PaiementServiceImple implements PaiementContratService {
	@Autowired
	ModePaiementRepository modePaiementRepository;
	@Autowired
	PaiementContratRepository paiementContratRepository;
	@Autowired
	ContratRepository contratRepository;

	@Override
	public PaiementContratDto add(PaiementContratDto dto) { 
		PaiementContratDto response=new PaiementContratDto();
		if (dto==null) {
			response.setCode(305); 
			response.setTitre("Paiement");
			response.setStatut("Error");
			response.setDescription("Veuillez renseigner les champs concerné au paiement");
			return response;
		}
		
		Contrat contrat=contratRepository.getById(dto.getUuidContrat()); 
		if (contrat==null) {
			response.setCode(305);
			response.setTitre("Paiement");
			response.setStatut("Error");
			response.setDescription("Le contrat a regler n'a pas été trouver");
			response.setUuidContrat(dto.getUuidContrat());
			response.setMontant(dto.getMontant());
			return response;
		}
		
		if (contrat.getMontant()<contrat.getPayer()+dto.getMontant()) {
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
		contrat.setPayer(contrat.getPayer()+dto.getMontant());
		contratRepository.save(contrat);
				
		PaiementContrat paiementContrat=paiementContratRepository.save(Mapper.toPaiement(dto,contrat,modePaiement));
		response=Mapper.toPaiementDTO(paiementContrat);
		response.setCode(200);
		response.setTitre("Paiement");
		response.setStatut("Success");
		response.setDescription("Le paiement a bien reussi");
		
		return response;
	}

	@Override
	public PaiementContratDto update(PaiementContratDto dto, String uuid) {
		PaiementContratDto response=new PaiementContratDto();
		if (dto==null) {
			response.setCode(305);
			response.setTitre("Paiement");
			response.setStatut("Error");
			response.setDescription("Veuillez renseigner les champs concerné au paiement");
			return response;
		}
		
		Contrat contrat=contratRepository.getById(dto.getUuidContrat()); 
		if (contrat==null) {
			response.setCode(305);
			response.setTitre("Paiement");
			response.setStatut("Error");
			response.setDescription("Le contrat a regler n'a pas été trouver");
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
		PaiementContrat paiementContrat=paiementContratRepository.save(Mapper.toPaiement(dto,contrat,modePaiement));
		response=Mapper.toPaiementDTO(paiementContrat);
		response.setCode(200);
		response.setTitre("Paiement");
		response.setStatut("Success");
		response.setDescription("Le montant payer a été modifier");
		
		return response;
	}

	@Override
	public List<PaiementContratDto> findAll() { 
		List<PaiementContrat> liste = paiementContratRepository.findAll();  
		List<PaiementContratDto> listeDTO = new ArrayList<>();
		liste.forEach(el -> listeDTO.add(Mapper.toPaiementDTO(el)));
		return listeDTO;
	}

	@Override
	public PaiementContratDto getByUuid(String uuid) {  
		System.err.println("************Une ligne");
		Optional<PaiementContrat> paiementContrat=paiementContratRepository.findById(uuid); 
		if (paiementContrat.isPresent()) {
			return Mapper.toPaiementDTO(paiementContrat.get());
		}
		return new PaiementContratDto();
	}

	@Override
	public void delete(String uuid) {
		paiementContratRepository.deleteById(uuid);	
	}

	@Override
	public List<PaiementContratDto> getPaiementByContrat(String uuidContrat) {
		System.err.println("************Liste");
		List<PaiementContrat> liste = paiementContratRepository.getPaiementByContrat(uuidContrat);  
		List<PaiementContratDto> listeDTO = new ArrayList<>();
		liste.forEach(el -> listeDTO.add(Mapper.toPaiementDTO(el)));
		return listeDTO;
	}

}
