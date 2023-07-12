package com.immobilier.serviceImple;
 
import java.time.Period;
import java.util.ArrayList; 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 

import com.immobilier.dto.ContratDetailDto; 
import com.immobilier.enumeration.StatutDomaine;
import com.immobilier.enumeration.TypeAnnonce;
import com.immobilier.enumeration.TypeContrat;
import com.immobilier.mapper.Mapper;
import com.immobilier.model.Contrat;
import com.immobilier.model.ContratDetail;
import com.immobilier.model.Domaine; 
import com.immobilier.model.ParcelleAppartemnt;
import com.immobilier.repository.ContratDetailRepository;
import com.immobilier.repository.ContratRepository;
import com.immobilier.repository.DomaineRepository;
import com.immobilier.repository.ParcelleAppartemntRepository;
import com.immobilier.service.ContratDetailService; 


@Service
public class ContratDetailServiceImple  implements ContratDetailService{

	@Autowired
	private ContratRepository contratRepository;
	@Autowired
	private ContratDetailRepository contratDetailRepository;	
	@Autowired
	private ParcelleAppartemntRepository parcelleAppartemntRepository;
	@Autowired
	private DomaineRepository domaineRepository; 
	private double montant=0,avance=0;
	private int nbMois=0;
	
	public ContratDetailDto add(ContratDetailDto dto) {
		
		ContratDetailDto response=new ContratDetailDto(); 
		if (dto==null) {
			response.setCode(305);
			response.setTitre("Information de appartement");
			response.setStatut("Error");
			response.setDescription("Veuillez sélectionner l'appartement");
			return response;
		}  
		
		Contrat contrat=contratRepository.getById(dto.getUuidContrat());
		if (contrat==null) {
			response.setCode(305);
			response.setTitre("Contrat introuvable...");
			response.setStatut("Error");
			response.setDescription("Ce contrat n'a pas été trouver dans la base des données");
			return response;
		}   
		if (!contrat.getTypeContrat().equals(TypeContrat.VENTE)) { 
			if (dto.getDebut()==null || dto.getFin()==null) {
				response.setCode(305);
				response.setTitre("Periode");
				response.setStatut("Error");
				response.setDescription("La période du contrat n'a pas été definir, "
						+ " assurez-vous que l'appartement est de type "+TypeContrat.VENTE);
				return response;
			}
			Period period=Period.between(dto.getDebut(), dto.getFin());  
			if (nombreDeMois(period.getDays(), period.getMonths(), period.getYears())<=0) {
				response.setCode(305);
				response.setTitre("Periode");
				response.setStatut("Error");
				response.setDescription("Veuillez definir la période du contrat");
				return response;
			} 
		} 
		
		ParcelleAppartemnt parcelleAppartemnt=parcelleAppartemntRepository.getById(dto.getUuidParcelApp());
		if (parcelleAppartemnt==null) {
			response.setCode(305);
			response.setTitre("Appartemnt introuvable...");
			response.setStatut("Error");
			response.setDescription("Cet appartement n'a pas été trouver dans la base des données");
			return response;
		} 
		 
		ContratDetail contratDetail=contratDetailRepository.save(Mapper.toContratDetail(dto, contrat, parcelleAppartemnt));
		response=Mapper.toContratDetailDTO(contratDetail);
		response.setCode(200);
		response.setTitre("Appartement");
		response.setStatut("Success");
		response.setDescription("Cet appartement a pas été ajouter au contrat");  
		//Update contrat
		this.updateContrat(contratDetail); 
		this.updateStatutAppartementParcelle(parcelleAppartemnt,contrat);
		return response;
	}

	@Override
	public ContratDetailDto update(ContratDetailDto dto, String uuid) {
		ContratDetailDto response=new ContratDetailDto();
		if (dto==null) {
			response.setCode(305);
			response.setTitre("Information de appartement");
			response.setStatut("Error");
			response.setDescription("Veuillez sélectionner l'appartement");
			return response;
		} 
		 
		Contrat contrat=contratRepository.getById(dto.getUuidContrat()); 
		if (contrat==null) {
			response.setCode(305);
			response.setTitre("Contrat introuvable...");
			response.setStatut("Error");
			response.setDescription("Ce contrat n'a pas été trouver dans la base des données");
			return response;
		}  
		
		if (!contrat.getTypeContrat().equals(TypeContrat.VENTE)) {
			Period period=Period.between(dto.getDebut(), dto.getFin());
			if (period.getMonths()<=0) {
				response.setCode(305);
				response.setTitre("Periode");
				response.setStatut("Error");
				response.setDescription("Veuillez definir la période du contrat");
				return response;
			}
		}
		
		ParcelleAppartemnt parcelleAppartemnt=parcelleAppartemntRepository.getById(dto.getUuidParcelApp());
		if (parcelleAppartemnt==null) {
			response.setCode(305);
			response.setTitre("Appartemnt introuvable...");
			response.setStatut("Error");
			response.setDescription("Cet appartement n'a pas été trouver dans la base des données");
			return response;
		} 
		dto.setUuid(uuid); 
		ContratDetail contratDetail=contratDetailRepository.save(Mapper.toContratDetail(dto, contrat, parcelleAppartemnt));
		response=Mapper.toContratDetailDTO(contratDetail);
		response.setCode(200);
		response.setTitre("Appartemnt");
		response.setStatut("Success");
		response.setDescription("Cet appartement a été ajouter au contrat");
		
		//Update contrat
		this.updateContrat(contratDetail);
		this.updateStatutAppartementParcelle(parcelleAppartemnt,contrat);
		return response;
	}

	@Override
	public List<ContratDetailDto> getDetailContrat(String uuidContrat) {
		List<ContratDetail> liste = contratDetailRepository.getDetailByContrat(uuidContrat);
		List<ContratDetailDto> listeDTO = new ArrayList<>();
		liste.forEach(val -> listeDTO.add(Mapper.toContratDetailDTO(val)));
		return listeDTO;
	}


	@Override
	public ContratDetailDto getByUuid(String uuid) {
		ContratDetail contratDetail=contratDetailRepository.getById(uuid);
		return Mapper.toContratDetailDTO(contratDetail);
	}

	@Override
	public ContratDetailDto delete(String uuid) { 
		ContratDetailDto response=new ContratDetailDto();
		if (uuid.isEmpty()) {
			response.setTitre("Suppression...");
			response.setDescription("La suppression a échoué!");
			response.setCode(350);
			response.setStatut("Error");  
			return response;
		} 
		
		Optional<ContratDetail> contratDetailOp=contratDetailRepository.findById(uuid); 
		if (!contratDetailOp.isPresent()) {
			response.setTitre("Suppression...");
			response.setDescription("Le contrat à supprimer n'a pas été trouver!");
			response.setCode(350);
			response.setStatut("Error"); 
			return response;
		}
		//TODO Effectuer l'action de supprimer
		contratDetailRepository.deleteById(uuid); 
		
		response.setTitre("Suppression...");
		response.setDescription("Cet appartement a été bien supprimer dans le contrat!");
		response.setCode(200);
		response.setStatut("Success"); 
		
		//Update contrat
		this.updateContrat(contratDetailOp.get());
		//Update statut appartement
		ParcelleAppartemnt parcelleAppartemnt= parcelleAppartemntRepository.getById(contratDetailOp.get().getParcelleAppartemnt().getUuid());
		if (parcelleAppartemnt!=null) {
			parcelleAppartemnt.setStatut(StatutDomaine.ANNONCE);
			parcelleAppartemntRepository.save(parcelleAppartemnt);
			
			Domaine domaine=domaineRepository.getById(parcelleAppartemnt.getDomaine().getUuid());
			if (domaine!=null) {
				domaine.setStatut(StatutDomaine.ANNONCE);
				domaineRepository.save(domaine);
			}
		}
		return response;
	}
	
	
	private void updateContrat(ContratDetail cp) {  
		
		if (cp.getContrat().getTypeContrat().equals(TypeContrat.VENTE)) {
			nbMois=1;
		}else {
			Period period=Period.between(cp.getDebut(), cp.getFin());
			nbMois=nombreDeMois(period.getDays(), period.getMonths(), period.getYears());
		}
		
		montant=0; 
		avance=0;
		Contrat contrat=contratRepository.getById(cp.getContrat().getUuid()); 
		if (contrat!=null) { 
			List<ContratDetail> cd=contratDetailRepository.getDetailByContrat(contrat.getUuid()); 
			cd.forEach(val->{ 
				if (cp.getContrat().getTypeContrat().equals(TypeContrat.VENTE)) {
					montant+=(val.getPrixLoyer());
					avance+=(val.getPrixLoyer()); 
				}else {
					montant+=(val.getPrixLoyer()*nbMois);
					avance+=(val.getAvance()*val.getPrixLoyer()); 
				}
			});
			contrat.setPayer(avance);
			contrat.setMontant(montant); 
			contratRepository.save(contrat);
		}  
	}
	
	private void updateStatutAppartementParcelle(ParcelleAppartemnt parcelleAppartemnt,Contrat contrat) {  
		if (contrat.getTypeContrat().equals(TypeContrat.LOCATION)) {
			parcelleAppartemnt.setStatut(StatutDomaine.LOUER);
		}else if (contrat.getTypeContrat().equals(TypeContrat.VENTE)) {
			parcelleAppartemnt.setStatut(StatutDomaine.VENDU);
		} else if (contrat.getTypeContrat().equals(TypeContrat.BAIE)) {
			parcelleAppartemnt.setStatut(StatutDomaine.BAYER);
		}
		parcelleAppartemnt=parcelleAppartemntRepository.save(parcelleAppartemnt); 
		this.controlStatutDomaine(parcelleAppartemnt);		
		System.err.println("*********************************"+parcelleAppartemnt);
	}
	
	private void controlStatutDomaine(ParcelleAppartemnt parcelleAppartemnt){
		List<ParcelleAppartemnt> annonce=parcelleAppartemntRepository.findAllByStatutAndDomaineUuid(StatutDomaine.ANNONCE,parcelleAppartemnt.getDomaine().getUuid());
		if (annonce.isEmpty()) {
			Domaine domaine=domaineRepository.getById(parcelleAppartemnt.getDomaine().getUuid());
			if (domaine!=null) {
				if (domaine.getTypeAnonce().equals(TypeAnnonce.LOCATION)) {
					domaine.setStatut(StatutDomaine.LOUER);
				}else if (domaine.getTypeAnonce().equals(TypeAnnonce.VENTE)) {
					domaine.setStatut(StatutDomaine.VENDU);
				}else if (domaine.getTypeAnonce().equals(TypeAnnonce.BAIE)) {
					domaine.setStatut(StatutDomaine.BAYER);
				} else if (domaine.getTypeAnonce().equals(TypeAnnonce.EN_MIXTE)) {
					domaine.setStatut(StatutDomaine.MIXTE);
				}
				domaineRepository.save(domaine);
			}
		}else {
			annonce=parcelleAppartemntRepository.findAllByStatutAndDomaineUuid(StatutDomaine.AUCUN,parcelleAppartemnt.getDomaine().getUuid());
			if (annonce.isEmpty()) {
				Domaine domaine=domaineRepository.getById(parcelleAppartemnt.getDomaine().getUuid());
				domaine.setStatut(StatutDomaine.ANNONCE);
				domaineRepository.save(domaine);
			}else {
				Domaine domaine=domaineRepository.getById(parcelleAppartemnt.getDomaine().getUuid());
				domaine.setStatut(StatutDomaine.AUCUN);
				domaineRepository.save(domaine);
			}
		} 
	}
	
	private int nombreDeMois(int jours,int mois,int annee) {
		int nombre=0; 
		if (jours>=25) {
			nombre+=1;
		} 
		nombre+=mois+annee*12;
		return nombre;
	}
 
}
