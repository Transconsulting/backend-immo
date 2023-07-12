package com.immobilier.serviceImple;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.immobilier.dto.ParcelleAppartemntImageDto;
import com.immobilier.mapper.Mapper;
import com.immobilier.model.ParcelleAppartemnt;
import com.immobilier.model.ParcelleAppartemntImage;
import com.immobilier.model.StoredFile;
import com.immobilier.repository.ParcelleAppartemntImageRepository;
import com.immobilier.repository.ParcelleAppartemntRepository;
import com.immobilier.repository.StoredFilesRepository;
import com.immobilier.service.ParcelleAppartemntImageService;

@Service
public class ParcelleAppartemntImageServiceImple implements ParcelleAppartemntImageService {
	
	@Autowired
	ParcelleAppartemntRepository parcelleAppartemntRepository;
	
	@Autowired
	StoredFilesRepository filesRepository;
	
	@Autowired
	ParcelleAppartemntImageRepository parcelleAppartemntImageRepository;
	

	@Override
	public ParcelleAppartemntImageDto addParcelleAppartemntImage(
			ParcelleAppartemntImageDto parcelleAppartemenntAppartemntImageDto) {
		// TODO Auto-generated method stub
		
		ParcelleAppartemntImage parcelleAppartemntImage =  new ParcelleAppartemntImage();
		StoredFile image = filesRepository.findById(parcelleAppartemenntAppartemntImageDto.getUuidImage()).orElseThrow(null);
		ParcelleAppartemnt parcelleAppartemnt = parcelleAppartemntRepository.findById(parcelleAppartemenntAppartemntImageDto.getUuidParcelleAppartement()).orElseThrow(null);
		
		parcelleAppartemntImage.setUuid(parcelleAppartemenntAppartemntImageDto.getUuid());
		parcelleAppartemntImage.setImage(image);
		parcelleAppartemntImage.setParcelleAppartemnt(parcelleAppartemnt);
		ParcelleAppartemntImage appartemntImageSave = parcelleAppartemntImageRepository.save(parcelleAppartemntImage);
		return Mapper.toParcelleAppartemntImageDto(appartemntImageSave);
	}

	@Override
	public ParcelleAppartemntImageDto updateParcelleAppartemntImage(
			ParcelleAppartemntImageDto parcelleAppartemenntAppartemntImageDto, String uuid) {
		// TODO Auto-generated method stub
		ParcelleAppartemntImage parcelleAppartemntImage = parcelleAppartemntImageRepository.findById(uuid).orElseThrow(null);
		StoredFile image = filesRepository.findById(parcelleAppartemenntAppartemntImageDto.getUuidImage()).orElseThrow(null);
		ParcelleAppartemnt parcelleAppartemnt = parcelleAppartemntRepository.findById(parcelleAppartemenntAppartemntImageDto.getUuidParcelleAppartement()).orElseThrow(null);
		
		parcelleAppartemntImage.setUuid(parcelleAppartemenntAppartemntImageDto.getUuid());
		parcelleAppartemntImage.setImage(image);
		parcelleAppartemntImage.setParcelleAppartemnt(parcelleAppartemnt);
		ParcelleAppartemntImage appartemntImageSave = parcelleAppartemntImageRepository.save(parcelleAppartemntImage);
		return Mapper.toParcelleAppartemntImageDto(appartemntImageSave);
	}

	@Override
	public List<ParcelleAppartemntImageDto> findAll() {
		// TODO Auto-generated method stub
		List<ParcelleAppartemntImage>  parcelleAppartemntImages  = parcelleAppartemntImageRepository.findAll();
		List<ParcelleAppartemntImageDto> appartemntImageDtos = new ArrayList<ParcelleAppartemntImageDto>();
		parcelleAppartemntImages.forEach(parcelle -> appartemntImageDtos.add(Mapper.toParcelleAppartemntImageDto(parcelle)));
		return appartemntImageDtos;
	}

	@Override
	public List<ParcelleAppartemntImageDto> findAllByParcelleAppartemnt(String uuid) {
		// TODO Auto-generated method stub
		List<ParcelleAppartemntImage>  parcelleAppartemntImages  = parcelleAppartemntImageRepository.findAllImageByParcelleAppartemnt(uuid);
		List<ParcelleAppartemntImageDto> appartemntImageDtos = new ArrayList<ParcelleAppartemntImageDto>();
		parcelleAppartemntImages.forEach(parcelle -> appartemntImageDtos.add(Mapper.toParcelleAppartemntImageDto(parcelle)));
		return appartemntImageDtos;
	}

	@Override
	public ParcelleAppartemntImageDto getParcelleAppartemntImage(String uuid) {
		//TODO Auto-generated method stub
		ParcelleAppartemntImage parcelleAppartemntImage = parcelleAppartemntImageRepository.findById(uuid).orElseThrow(null);
		return Mapper.toParcelleAppartemntImageDto(parcelleAppartemntImage);
	}

	@Override
	public void deleteParcelleAppartemntImage(String uuid) {
		// TODO Auto-generated method stub
		parcelleAppartemntImageRepository.deleteById(uuid);
	}

}
