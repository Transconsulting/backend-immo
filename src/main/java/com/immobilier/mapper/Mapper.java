package com.immobilier.mapper;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.immobilier.dto.AffectationDto;
import com.immobilier.dto.AgenceDto;
import com.immobilier.dto.AgentDto;
import com.immobilier.dto.ClientDto;
import com.immobilier.dto.CommandeClientDto;
import com.immobilier.dto.CommuneDto;
import com.immobilier.dto.ContratDto;
import com.immobilier.dto.DetailCommandeClientDto;
import com.immobilier.dto.ContratDetailDto;
import com.immobilier.dto.DomaineDto;
import com.immobilier.dto.IntereseDto;
import com.immobilier.dto.MaterielDto;
import com.immobilier.dto.ModePaiementDto;
import com.immobilier.dto.PaiementContratDto;
import com.immobilier.dto.PaiementFactureDto;
import com.immobilier.dto.ParcelleApartemntDetailDto;
import com.immobilier.dto.ParcelleAppartementVideoDto;
import com.immobilier.dto.ParcelleAppartemntDto;
import com.immobilier.dto.ParcelleAppartemntImageDto;
import com.immobilier.dto.ProfessionDto;
import com.immobilier.dto.ProprietaireDto;
import com.immobilier.dto.QuartierDto;
import com.immobilier.dto.StoredFileDto;
import com.immobilier.dto.StoredFileInfoDto;
import com.immobilier.dto.UtilisateurDto;
import com.immobilier.dto.VilleDto;
import com.immobilier.enumeration.EnumRole;
import com.immobilier.model.Affectation;
import com.immobilier.model.Agence;
import com.immobilier.model.Agent;
import com.immobilier.model.Client;
import com.immobilier.model.CommandeClient;
import com.immobilier.model.Commune;
import com.immobilier.model.Contrat;
import com.immobilier.model.ContratDetail;
import com.immobilier.model.DetailCommandeClient;
import com.immobilier.model.Domaine;
import com.immobilier.model.Interese;
import com.immobilier.model.Materiel;
import com.immobilier.model.ModePaiement;
import com.immobilier.model.PaiementContrat;
import com.immobilier.model.PaiementFacture;
import com.immobilier.model.ParcelleApartemntDetail;
import com.immobilier.model.ParcelleAppartementVideo;
import com.immobilier.model.ParcelleAppartemnt;
import com.immobilier.model.ParcelleAppartemntImage;
import com.immobilier.model.Profession;
import com.immobilier.model.Proprietaire;
import com.immobilier.model.Quartier;
import com.immobilier.model.StoredFile;
import com.immobilier.model.Utilisateur;
import com.immobilier.model.Ville; 

public class Mapper {
	
	public static AgentDto toAgentDto(Agent agent) {
		
		AgentDto agentDto = new AgentDto();
		
		agentDto.setNom(agent.getNom());
		agentDto.setPrenoms(agent.getPrenoms());
		
		agentDto.setVille(agent.getQuartier().getCommune().getVille().getNomVille());
		agentDto.setCommune(agent.getQuartier().getCommune().getNomCommune());
		agentDto.setQuartier(agent.getQuartier().getNomQuartier());
		agentDto.setUuidQuartier(agent.getQuartier().getUuid());
		
		agentDto.setTel(agent.getTel());
		agentDto.setUuid(agent.getUuid());
		agentDto.setUuidProfession(agent.getProfession().getUuid());
		agentDto.setProfession(agent.getProfession().getLibelle());
		agentDto.setType(agent.getType());
		
		return agentDto;
	}

	
	public static ProprietaireDto toProprietaireDto(Proprietaire proprietaire) {
		
		ProprietaireDto proprietaireDto = new ProprietaireDto();
		proprietaireDto.setNom(proprietaire.getNom());
		proprietaireDto.setPrenoms(proprietaire.getPrenoms());
		proprietaireDto.setDateNaiss(proprietaire.getDateNaiss());
		proprietaireDto.setTel(proprietaire.getTel());
		proprietaireDto.setVille(proprietaire.getVille());
		proprietaireDto.setUuid(proprietaire.getUuid());
		
		return proprietaireDto;
	}
	
	public static DomaineDto toDomaineDto(Domaine domaine) {
		
		DomaineDto domaineDto = new DomaineDto();
		domaineDto.setLibelle(domaine.getLibelle());
		domaineDto.setType(domaine.getType());
		
		domaineDto.setVille(domaine.getQuartier().getCommune().getVille().getNomVille());
		domaineDto.setCommune(domaine.getQuartier().getCommune().getNomCommune());
		domaineDto.setQuartier(domaine.getQuartier().getNomQuartier());
		domaineDto.setUuidQuartier(domaine.getQuartier().getUuid());
		
		domaineDto.setLongitude(domaine.getLongitude());
		domaineDto.setLattitude(domaine.getLattitude());
		domaineDto.setUuid(domaine.getUuid());
		domaineDto.setUuidAgent(domaine.getAgent().getUuid());
		domaineDto.setUuidProprietaire(domaine.getProprietaire().getUuid());
		domaineDto.setStatutDomaine(domaine.getStatut());
		domaineDto.setTypeAnonce(domaine.getTypeAnonce());
		domaineDto.setType(domaine.getType());
		domaineDto.setAgent(domaine.getAgent().getPrenoms()+" "+domaine.getAgent().getNom());
		domaineDto.setProprietaire(domaine.getProprietaire().getPrenoms()+" "+domaine.getProprietaire().getNom());
		domaineDto.setTelephoneProprietaire(domaine.getProprietaire().getTel());
		
		return domaineDto;
	}
	
	public static ParcelleAppartemntDto toParcelleAppartemntDto(ParcelleAppartemnt parcelleAppartemnt) {
		
		ParcelleAppartemntDto parcelleAppartemntDto = new ParcelleAppartemntDto();
		parcelleAppartemntDto.setNumero(parcelleAppartemnt.getNumero());
		parcelleAppartemntDto.setPrix(parcelleAppartemnt.getPrix());
		parcelleAppartemntDto.setUuid(parcelleAppartemnt.getUuid());
		parcelleAppartemntDto.setAppDescription(parcelleAppartemnt.getAppDescription());
		parcelleAppartemntDto.setStatutDomaine(parcelleAppartemnt.getStatut());
		parcelleAppartemntDto.setUuidDomaine(parcelleAppartemnt.getDomaine().getUuid());
		parcelleAppartemntDto.setDomaine(parcelleAppartemnt.getDomaine().getLibelle());
		parcelleAppartemntDto.setAvance(parcelleAppartemnt.getAvance());
		parcelleAppartemntDto.setFraisAgence(parcelleAppartemnt.getFraisAgence());
		parcelleAppartemntDto.setCaution(parcelleAppartemnt.getCaution()); 
		parcelleAppartemntDto.setUuidProprietaire(parcelleAppartemnt.getDomaine().getProprietaire().getUuid());
		
		return parcelleAppartemntDto;
	}	
	
	public static ParcelleApartemntDetailDto toParcelleApartemntDetailDto(ParcelleApartemntDetail parcelleApartemntDetail) {
		
		ParcelleApartemntDetailDto parcelleApartemntDetailDto = new ParcelleApartemntDetailDto();
		parcelleApartemntDetailDto.setLibelle(parcelleApartemntDetail.getLibelle());
		parcelleApartemntDetailDto.setSize(parcelleApartemntDetail.getSize());
		parcelleApartemntDetailDto.setSurface(parcelleApartemntDetail.getUnite());
		parcelleApartemntDetailDto.setUuid(parcelleApartemntDetail.getUuid());
		parcelleApartemntDetailDto.setUuidParcelleAppartemnt(parcelleApartemntDetail.getParcelleAppartemnt().getUuid());
		parcelleApartemntDetailDto.setNumeroParcelleAppartement(parcelleApartemntDetail.getParcelleAppartemnt().getNumero());
		parcelleApartemntDetailDto.setAppDescription(parcelleApartemntDetail.getParcelleAppartemnt().getAppDescription());
		return parcelleApartemntDetailDto;
	}
	
	//TODO Ville
	public static VilleDto toVilleDto(Ville ville) {
		VilleDto villeDto = new VilleDto();
		villeDto.setLibelle(ville.getNomVille());
		villeDto.setUuid(ville.getUuid());
		return villeDto;
	}
	
	//TODO Commune
	public static CommuneDto toCommuneDto(Commune commune) {
		CommuneDto communeDto = new CommuneDto();
		communeDto.setLibelle(commune.getNomCommune());
		communeDto.setUuidVile(commune.getVille().getUuid());
		communeDto.setVille(commune.getVille().getNomVille());
		communeDto.setUuid(commune.getUuid()); 
		return communeDto;
	}
	
	//TODO Quartier
	public static QuartierDto toQuartierDto(Quartier quartier) {
		QuartierDto quartierDto = new QuartierDto();
		quartierDto.setLibelle(quartier.getNomQuartier());
		quartierDto.setVille(quartier.getCommune().getVille().getNomVille());
		quartierDto.setUuidCommune(quartier.getCommune().getUuid());
		quartierDto.setCommune(quartier.getCommune().getNomCommune());
		quartierDto.setUuid(quartier.getUuid());
		return quartierDto;
	}
	
	//TODO CLIENT
	public static ClientDto toClientDTO(Client client) {
		ClientDto dto=new ClientDto();
		dto.setUuid(client.getUuid());
		dto.setNom(client.getNom());
		dto.setPrenom(client.getPrenom());
		dto.setDateNaissance(client.getDateNaissance());
		dto.setEtatCivil(client.getEtatCivil());
		dto.setNombreEnfant(client.getNombreEnfant());
		dto.setTelephone(client.getTelephone()); 
		List<ContratDto> listeDto=new ArrayList<ContratDto>();
		client.getListeContrat().forEach(val->listeDto.add(Mapper.toContratDTO(val)));
		dto.setListeContratDTO(listeDto);
		return dto;
	}
		
		public static Client toClient(ClientDto dto) {
			Client client=new Client();
			client.setUuid(dto.getUuid());
			client.setNom(dto.getNom());
			client.setPrenom(dto.getPrenom());
			client.setDateNaissance(dto.getDateNaissance());
			client.setEtatCivil(dto.getEtatCivil());
			client.setNombreEnfant(dto.getNombreEnfant());
			client.setTelephone(dto.getTelephone());  
			return client;
		}
		
		
		//TODO Contrat
		public static ContratDto toContratDTO(Contrat c) {
			ContratDto dto=new ContratDto();
			dto.setUuid(c.getUuid());
			dto.setUuidClient(c.getClient().getUuid());
			dto.setClient(c.getClient().getPrenom()+" "+c.getClient().getNom());
			dto.setTelephoneClient(c.getClient().getTelephone());
			dto.setMontant(c.getMontant());
			dto.setPayer(c.getPayer());
			dto.setReglePaiement(c.getReglePaiement());
			dto.setTypeContrat(c.getTypeContrat());
			dto.setEtatAvance(c.isEtatAvance());
			dto.setStatutContrat(c.isStatutContrat());
			
			List<ContratDetailDto> listeContratDetailsDTO=new ArrayList<ContratDetailDto>();
			c.getListeContratDetails().forEach(val->listeContratDetailsDTO.add(Mapper.toContratDetailDTO(val)));
			dto.setListeContratDetailsDTO(listeContratDetailsDTO);
						
			List<PaiementContratDto> listePaiementsDTO=new ArrayList<PaiementContratDto>();
			c.getListePaiements().forEach(val->listePaiementsDTO.add(Mapper.toPaiementDTO(val)));
			dto.setListePaiementsDTO(listePaiementsDTO);
			
			return dto;
		}
		
		public static Contrat toContrat(ContratDto dto,Client client) {
			Contrat c=new Contrat();
			c.setUuid(dto.getUuid());
			c.setClient(client);
			c.setMontant(dto.getMontant());
			c.setPayer(dto.getPayer());
			c.setReglePaiement(dto.getReglePaiement());
			c.setTypeContrat(dto.getTypeContrat());
			c.setEtatAvance(dto.isEtatAvance());
			c.setStatutContrat(dto.getStatutContrat());
			return c;
		}
		
		
		//TODO ContratDetail
		public static ContratDetailDto toContratDetailDTO(ContratDetail cd) {
			ContratDetailDto dto=new ContratDetailDto();
			dto.setUuid(cd.getUuid());
			dto.setUuidContrat(cd.getContrat().getUuid());
			dto.setUuidproprietaire(cd.getParcelleAppartemnt().getDomaine().getProprietaire().getUuid());
			dto.setUuidDomaine(cd.getParcelleAppartemnt().getDomaine().getUuid());
			dto.setDomaine(cd.getParcelleAppartemnt().getDomaine().getLibelle());
			dto.setUuidParcelApp(cd.getParcelleAppartemnt().getUuid());
			dto.setNumeroParcelApp(cd.getParcelleAppartemnt().getNumero()); 
			dto.setCaution(cd.getCaution());
			dto.setFraisAgence(cd.getFraisAgence());
			dto.setAvance(cd.getAvance());
			dto.setDebut(cd.getDebut());
			dto.setFin(cd.getFin()); 
			dto.setPrixLoyer(cd.getPrixLoyer());
			return dto;
		}
		
		public static ContratDetail toContratDetail(ContratDetailDto dto, Contrat contrat,ParcelleAppartemnt parcelleAppartemnt) {
			ContratDetail cd=new ContratDetail();
			cd.setUuid(dto.getUuid());
			cd.setContrat(contrat);
			cd.setParcelleAppartemnt(parcelleAppartemnt); 
			cd.setCaution(dto.getCaution());
			cd.setDebut(dto.getDebut());
			cd.setAvance(dto.getAvance());
			cd.setFraisAgence(dto.getFraisAgence());
			cd.setFin(dto.getFin());
			cd.setPrixLoyer(dto.getPrixLoyer()); 
			return cd;
		}
		
		//TODO ModePaiement 
		public static ModePaiementDto toModePaiementDTO(ModePaiement md) {
			ModePaiementDto dto=new ModePaiementDto();
			dto.setUuid(md.getUuid());
			dto.setLibelle(md.getLibelle()); 
			List<PaiementContratDto> listePaiementDTO=new ArrayList<PaiementContratDto>();
			md.getListePaiements().forEach(val->listePaiementDTO.add(Mapper.toPaiementDTO(val)));
			dto.setListePaiementsDTO(listePaiementDTO);
			return dto;
		}
		
		//TODO Paiement
		public static PaiementContratDto toPaiementDTO(PaiementContrat p) {
			PaiementContratDto dto=new PaiementContratDto();
			dto.setUuid(p.getUuid());
			dto.setUuidContrat(p.getContrat().getUuid());
			dto.setUuidModePaiement(p.getModePaiement().getUuid());
			dto.setDatePaiement(p.getDatePaiement());
			dto.setMontant(p.getMontant());
			dto.setReference(p.getReference());
			
			return dto;
		}
		
		public static PaiementContrat toPaiement(PaiementContratDto dto,Contrat contrat,ModePaiement modePaiement) {
			PaiementContrat p=new PaiementContrat();
			p.setUuid(dto.getUuid());
			p.setContrat(contrat);
			p.setModePaiement(modePaiement);
			p.setDatePaiement(dto.getDatePaiement());
			p.setMontant(dto.getMontant());
			p.setReference(dto.getReference());
			
			return p;
		}
		
		//TODO PaiementFacture
		public static PaiementFactureDto toPaiementFactureDTO(PaiementFacture p) {
			PaiementFactureDto dto=new PaiementFactureDto();
			dto.setUuid(p.getUuid());
			dto.setUuidCommande(p.getCommande().getUuid());
			dto.setUuidModePaiement(p.getModePaiement().getUuid());
			dto.setDatePaiement(p.getDatePaiement());
			dto.setMontant(p.getMontant());
			dto.setReference(p.getReference());
			
			return dto;
		}
		
		public static PaiementFacture toPaiementFacture(PaiementFactureDto dto,CommandeClient commandeClient,ModePaiement modePaiement) {
			PaiementFacture p=new PaiementFacture();
			p.setUuid(dto.getUuid());
			p.setCommande(commandeClient);
			p.setModePaiement(modePaiement);
			p.setDatePaiement(dto.getDatePaiement());
			p.setMontant(dto.getMontant());
			p.setReference(dto.getReference());
			return p;
		}
		 
		//TODO Materiel
				public static MaterielDto toMaterielDto(Materiel mat) {
					MaterielDto dto=new MaterielDto();
					dto.setUuid(mat.getUuid());
					dto.setLibelle(mat.getLibelle());
					dto.setDescription(mat.getDescription());
					dto.setPrix(mat.getPrix());
					dto.setPhoto1(mat.getPhoto1());
					dto.setPhoto2(mat.getPhoto2());
					dto.setPhoto3(mat.getPhoto3());
					return dto;
				}
				
				public static Materiel toMateriel(MaterielDto dto) {
					Materiel mat=new Materiel();
					mat.setUuid(dto.getUuid());
					mat.setLibelle(dto.getLibelle());
					mat.setDescription(dto.getDescription());
					mat.setPrix(dto.getPrix());
					mat.setPhoto1(dto.getPhoto1());
					mat.setPhoto2(dto.getPhoto2());
					mat.setPhoto3(dto.getPhoto3());
					return mat;
				}
		
		//TODO CommandeClient
		public static CommandeClientDto toCommandeClientDto(CommandeClient cmd) {
			CommandeClientDto dto =new CommandeClientDto();
			dto.setUuid(cmd.getUuid());
			dto.setUuidClient(cmd.getClient().getUuid());
			dto.setNumCmd(cmd.getNumCmd());
			dto.setMontantCmd(cmd.getMontantCmd());
			dto.setDatCmd(cmd.getDatCmd());
			dto.setPayer(cmd.getPayer());
			/*
			if (cmd.getListDetailCommandeClient()!=null) {
				List<DetailCommandeClientDto> listeContratDetailsDTO=new ArrayList<DetailCommandeClientDto>();
				cmd.getListDetailCommandeClient().forEach(val->listeContratDetailsDTO.add(toDetailCommandeClientDto(val)));
				dto.setListDetailCommandeDto(listeContratDetailsDTO);
			}
			
			if (cmd.getListPaiementFacture()!=null) {
				List<PaiementFactureDto> listePaiementsDTO=new ArrayList<PaiementFactureDto>();
				cmd.getListPaiementFacture().forEach(val->listePaiementsDTO.add(toPaiementFactureDTO(val)));
				dto.setListPaiementFactureDto(listePaiementsDTO);
			}
			*/			
			return dto;
		}
		
		public static CommandeClient toCommandeClient(CommandeClientDto dto,Client client) {
			CommandeClient cmd =new CommandeClient();
			cmd.setUuid(dto.getUuid());
			cmd.setClient(client);
			cmd.setNumCmd(dto.getNumCmd());
			cmd.setMontantCmd(dto.getMontantCmd());
			cmd.setDatCmd(dto.getDatCmd());
			cmd.setPayer(dto.getPayer());
			return cmd;
		}
		//TODO Detail Commande
		public static DetailCommandeClientDto toDetailCommandeClientDto(DetailCommandeClient d) {
			DetailCommandeClientDto dto=new DetailCommandeClientDto();
			dto.setUuid(d.getUuid());
			dto.setUuidMateriel(d.getMateriel().getUuid());
			dto.setUuidCommande(d.getCommande().getUuid());
			dto.setPrixUnitaire(d.getPrixUnitaire());
			dto.setQuantite(d.getQuantite()); 
			return dto;
		}
		
		public static DetailCommandeClient toDetailCommandeClient(DetailCommandeClientDto dto,CommandeClient commandeClient,Materiel materiel) {
			DetailCommandeClient d=new DetailCommandeClient();
			d.setUuid(dto.getUuid());
			d.setMateriel(materiel);
			d.setCommande(commandeClient);
			d.setPrixUnitaire(dto.getPrixUnitaire());
			d.setQuantite(dto.getQuantite()); 
			return d;
		}
		
		//TODO Affectation
		public static AffectationDto toAffectationDto(Affectation affectation) {
			
			AffectationDto affectationDto = new AffectationDto();
			affectationDto.setNomClient(affectation.getNomClient());
			affectationDto.setTelClient(affectation.getTelClient());
			affectationDto.setDateAffectation(affectation.getDateAffectation());
			affectationDto.setVille(affectation.getQuartier().getCommune().getVille().getNomVille());
			affectationDto.setCommune(affectation.getQuartier().getCommune().getNomCommune());
			affectationDto.setQuartier(affectation.getQuartier().getNomQuartier());
			affectationDto.setTypeTravaux(affectation.getTypeTravaux());
			affectationDto.setDescripTravau(affectation.getDescripTravau());
			affectationDto.setUuidQuartier(affectation.getQuartier().getUuid());
			affectationDto.setUuidAgent(affectation.getAgent().getUuid());
			affectationDto.setUuid(affectation.getUuid());
			return affectationDto;
		}
		
		//TODO Agence
		public static AgenceDto toAgenceDto(Agence agence) {
			AgenceDto agenceDto = new AgenceDto();
			agenceDto.setNomAgence(agence.getNomAgence());
			agenceDto.setTel(agence.getTel());
			agenceDto.setAddress(agence.getAddress());
			agenceDto.setMail(agence.getMail());
		// 	agenceDto.setLogo(agence.getLogo());
			agenceDto.setUuid(agence.getUuid());
			return agenceDto;
		}
		
		/*********************************************************************************
		 * *****************************************************************************
		 * @param Utilisateur
		 * return dto
		 * ************************************************************************
		 */ 
		
		public static UserDetails toUserDetails(Utilisateur user) {
			Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
			for (Iterator iterator = user.getRoles().iterator(); iterator.hasNext();) {
				EnumRole enumRole = (EnumRole) iterator.next();
				authorities.add(new SimpleGrantedAuthority(enumRole.name()));
			}
			UserDetails userdetails = new User(user.getEmail(), user.getPassword(), authorities);
			return userdetails;
		}

		public static Utilisateur toUser(UtilisateurDto user) {
			Utilisateur utilisateur = new Utilisateur();
			utilisateur.setEmail(user.getEmail());
			utilisateur.setRoles(user.getRoles());
			return utilisateur;
		}

		public static UtilisateurDto toUtilisateurDto(Utilisateur user) {
			UtilisateurDto utilisateurDto = new UtilisateurDto();
			utilisateurDto.setUuid(user.getUuid());
			utilisateurDto.setNom(user.getNom());
			utilisateurDto.setPrenom(user.getPrenom());
			utilisateurDto.setTelephone(user.getTelephone());
			utilisateurDto.setEmail(user.getEmail());
			utilisateurDto.setOnline(user.isOnline());
			utilisateurDto.setEnabled(user.isEnabled());
			utilisateurDto.setNonExpired(user.isNonExpired());
			utilisateurDto.setNonLocked(user.isNonLocked());
			utilisateurDto.setRoles(user.getRoles());
			return utilisateurDto;
		}
		
		/**************************************************************
		 * *******************File******************************************
		 */
		 public static StoredFileDto toStoreFileDto(StoredFile fileDB) {
		       StoredFileDto result = new StoredFileDto();
		       result.setBytes(fileDB.getBytes());
		       result.setName(fileDB.getName());
		       result.setUuid(fileDB.getUuid());
		       result.setType(fileDB.getType());
		       return result;
		   }

		   public static StoredFileInfoDto toStoredFileInfoDto(StoredFile fileDB) {
		       StoredFileInfoDto result = new StoredFileInfoDto();
		       result.setName(fileDB.getName());
		       result.setUuid(fileDB.getUuid());
		       return result;
		   }
		   
		   
		 public static ParcelleAppartemntImageDto toParcelleAppartemntImageDto(ParcelleAppartemntImage parcelleAppartemntImage) {
			 ParcelleAppartemntImageDto dto =  new ParcelleAppartemntImageDto();
			 dto.setUuid(parcelleAppartemntImage.getUuid());
			 dto.setUuidImage(parcelleAppartemntImage.getImage().getUuid());
			 dto.setUuidParcelleAppartement(parcelleAppartemntImage.getParcelleAppartemnt().getUuid());
			 
			 byte[] encodeBase64 = Base64.getEncoder().encode(parcelleAppartemntImage.getImage().getBytes());
			    String base64Encoded;
				try{
					base64Encoded = new String(encodeBase64, "UTF-8");
					dto.setLibelleImage("data:"+parcelleAppartemntImage.getImage().getType()+";base64,"+base64Encoded);
				}catch (UnsupportedEncodingException e) { 
					e.printStackTrace();
				}
			 return dto;
		 }
		 public static ParcelleAppartementVideoDto toParcelleAppartementVideoDto(ParcelleAppartementVideo parcelleAppartementVideo) {
			 ParcelleAppartementVideoDto dto =  new ParcelleAppartementVideoDto();
			 dto.setUuid(parcelleAppartementVideo.getUuid());
			 dto.setUuidVideo(parcelleAppartementVideo.getVideo().getUuid());
			 dto.setUuidParcelleAppartement(parcelleAppartementVideo.getParcelleAppartemnt().getUuid());
			 
			 byte[] encodeBase64 = Base64.getEncoder().encode(parcelleAppartementVideo.getVideo().getBytes());
			    String base64Encoded;
				try{
					base64Encoded = new String(encodeBase64, "UTF-8");
					dto.setLibelleVideo("data:"+parcelleAppartementVideo.getVideo().getType()+";base64,"+base64Encoded);
				}catch (UnsupportedEncodingException e) { 
					e.printStackTrace();
				}
			 return dto;
		 }
		 
		 /*
		  * *****************************************************************************
		  * ****************************Profession***************************************
		  * *****************************************************************************
		  */
		 public static ProfessionDto toProfessionDto(Profession p) {
			 ProfessionDto dto=new ProfessionDto();
			 dto.setUuid(p.getUuid());
			 dto.setLibelle(p.getLibelle());
			 return dto;
		 }
		 
		 public static Profession toProfession(ProfessionDto dto) {
			 Profession p=new Profession();
			 p.setUuid(dto.getUuid());
			 p.setLibelle(dto.getLibelle());
			 return p;
		 }
		 
		 /*
		  * *****************************************************************************
		  * ****************************Parcelle Appartement Interesé***************************************
		  * *****************************************************************************
		  */
		 public static IntereseDto toIntereseDto(Interese interese) {
			 IntereseDto dto=new IntereseDto();
			 dto.setUuid(interese.getUuid());
			 dto.setCreated_at(interese.getDateCreated());
			 dto.setUpdated_at(interese.getLastUpdated());
			 dto.setParcelleAppartemnt(Mapper.toParcelleAppartemntDto(interese.getParcelleAppartemnt()));
			 dto.setUtilisateur(Mapper.toUtilisateurDto(interese.getUtilisateur()));
			 return dto;
		 }
		  
}
