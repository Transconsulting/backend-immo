package com.immobilier.serviceImple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.immobilier.dto.ParcelleApartemntDetailDto;
import com.immobilier.mapper.Mapper;
import com.immobilier.model.ParcelleApartemntDetail;
import com.immobilier.model.ParcelleAppartemnt;
import com.immobilier.repository.ParcelleApartemntDetailRepository;
import com.immobilier.repository.ParcelleAppartemntRepository;
import com.immobilier.service.ParcelleApartemntDetailService;

@Service
public class ParcelleApartemntDetailServiceImple implements ParcelleApartemntDetailService {
	
	@Autowired
	ParcelleApartemntDetailRepository parcelleApartemntDetailRepository;
	@Autowired
	ParcelleAppartemntRepository parcelleAppartemntRepository;

	@Override
	public ParcelleApartemntDetailDto saveParcelleApartemntDetail( ParcelleApartemntDetailDto dto) {
		
		ParcelleApartemntDetailDto response=new ParcelleApartemntDetailDto(); 
		ParcelleApartemntDetail parcelleApartemntDetail = new ParcelleApartemntDetail();
		if (dto==null) {
			response.setCode(305);
			response.setTitre("Détail appartement");
			response.setStatut("Error");
			response.setDescription("Saisissez les informations");
			return response;
		}
		
		Optional<ParcelleAppartemnt> parcelleApartemnt = parcelleAppartemntRepository.findById(dto.getUuidParcelleAppartemnt());
		if (!parcelleApartemnt.isPresent()) {
			response.setCode(305);
			response.setTitre("L'appartement ");
			response.setStatut("Error");
			response.setDescription("L'appartement conserné n'a pas été trouver dans la base de données");
			return response;
		}
		parcelleApartemntDetail.setLibelle(dto.getLibelle());
		parcelleApartemntDetail.setSize(dto.getSize());
		parcelleApartemntDetail.setUnite(dto.getSurface());
		parcelleApartemntDetail.setParcelleAppartemnt(parcelleApartemnt.get());
		ParcelleApartemntDetail parcelleApartemntDetailSave = parcelleApartemntDetailRepository.save(parcelleApartemntDetail);
		response= Mapper.toParcelleApartemntDetailDto(parcelleApartemntDetailSave);
		response.setCode(200);
		response.setTitre("Détail appartement ");
		response.setStatut("Success");
		response.setDescription("Un détail a été ajouter l'appartement");
		return response; 
	}

	@Override
	public ParcelleApartemntDetailDto updateParcelleApartemntDetail(
			ParcelleApartemntDetailDto dto, String uuid) {
		
		ParcelleApartemntDetailDto response=new ParcelleApartemntDetailDto(); 
		ParcelleApartemntDetail parcelleApartemntDetail = new ParcelleApartemntDetail();
		if (dto==null) {
			response.setCode(305);
			response.setTitre("Détail appartement");
			response.setStatut("Error");
			response.setDescription("Saisissez les informations");
			return response;
		}
		
		Optional<ParcelleAppartemnt> parcelleApartemnt = parcelleAppartemntRepository.findById(dto.getUuidParcelleAppartemnt());
		if (!parcelleApartemnt.isPresent()) {
			response.setCode(305);
			response.setTitre("L'appartement ");
			response.setStatut("Error");
			response.setDescription("L'appartement conserné n'a pas été trouver dans la base de données");
			return response;
		}
		
		Optional<ParcelleApartemntDetail> parcelOp=parcelleApartemntDetailRepository.findById(uuid);
		if (!parcelOp.isPresent()) {
			response.setCode(305);
			response.setTitre("Détail appartement ");
			response.setStatut("Error");
			response.setDescription("Le détail appartement a modifié n'a pas été trouver dans la base de données");
			return response;
		}
		parcelleApartemntDetail=parcelOp.get();
		parcelleApartemntDetail.setLibelle(dto.getLibelle());
		parcelleApartemntDetail.setSize(dto.getSize());
		parcelleApartemntDetail.setUnite(dto.getSurface());
		parcelleApartemntDetail.setParcelleAppartemnt(parcelleApartemnt.get());
		ParcelleApartemntDetail parcelleApartemntDetailUpdate = parcelleApartemntDetailRepository.save(parcelleApartemntDetail);
		response=Mapper.toParcelleApartemntDetailDto(parcelleApartemntDetailUpdate);
		response.setCode(200);
		response.setTitre("Détail appartement ");
		response.setStatut("Success");
		response.setDescription("Un détail a été ajouter l'appartement");
		return response;  
	}

	@Override
	public ParcelleApartemntDetailDto getByuuid(String uuid) {
		// TODO Auto-generated method stub
		ParcelleApartemntDetail parcelleApartemntDetail = new ParcelleApartemntDetail();
		parcelleApartemntDetail = parcelleApartemntDetailRepository.findById(uuid).orElseThrow(null);
		return Mapper.toParcelleApartemntDetailDto(parcelleApartemntDetail);
	}

	@Override
	public void deleteParcelleApartemntDetail(String uuid) {
		// TODO Auto-generated method stub
		parcelleApartemntDetailRepository.deleteById(uuid);
	}

	@Override
	public List<ParcelleApartemntDetailDto> findAllParcelleApartemntDetail() {
		// TODO Auto-generated method stub
		List<ParcelleApartemntDetail> parcelleApartemntDetails = parcelleApartemntDetailRepository.findAll();
		List<ParcelleApartemntDetailDto> parcelleApartemntDetailDtos = new ArrayList<ParcelleApartemntDetailDto>();
		parcelleApartemntDetails.forEach(parcelleApartemntDetail -> parcelleApartemntDetailDtos.add(Mapper.toParcelleApartemntDetailDto(parcelleApartemntDetail)));
		return parcelleApartemntDetailDtos;
	}

	@Override
	public List<ParcelleApartemntDetailDto> getParcelleApartemntDetail(String uuidParcelleApartement) {
		// TODO Auto-generated method stub
		List<ParcelleApartemntDetail> parcelleApartemntDetails = parcelleApartemntDetailRepository.getParcelleApartemntDetail(uuidParcelleApartement);
		List<ParcelleApartemntDetailDto> parcelleApartemntDetailDtos = new ArrayList<ParcelleApartemntDetailDto>();
		parcelleApartemntDetails.forEach(parcelleApartemntDetail -> parcelleApartemntDetailDtos.add(Mapper.toParcelleApartemntDetailDto(parcelleApartemntDetail)));
		return parcelleApartemntDetailDtos;
	}

}
