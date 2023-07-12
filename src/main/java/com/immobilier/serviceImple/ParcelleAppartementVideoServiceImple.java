package com.immobilier.serviceImple;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.immobilier.dto.ParcelleAppartementVideoDto; 
import com.immobilier.mapper.Mapper;
import com.immobilier.model.ParcelleAppartementVideo;
import com.immobilier.model.ParcelleAppartemnt; 
import com.immobilier.model.StoredFile;
import com.immobilier.repository.ParcelleAppartementVideoRepository; 
import com.immobilier.repository.ParcelleAppartemntRepository;
import com.immobilier.repository.StoredFilesRepository;
import com.immobilier.service.ParcelleAppartementVideoService; 

@Service
public class ParcelleAppartementVideoServiceImple implements ParcelleAppartementVideoService {
	
	@Autowired
	ParcelleAppartemntRepository parcelleAppartemntRepository;
	
	@Autowired
	StoredFilesRepository filesRepository;
	
	@Autowired
	ParcelleAppartementVideoRepository videoRepository;
	

	@Override
	public ParcelleAppartementVideoDto add(ParcelleAppartementVideoDto dto) {
		// TODO Auto-generated method stub
		
		ParcelleAppartementVideo parcelleAppartementVideo =  new ParcelleAppartementVideo();
		StoredFile video = filesRepository.findById(dto.getUuidVideo()).orElseThrow(null);
		ParcelleAppartemnt parcelleAppartemnt = parcelleAppartemntRepository.findById(dto.getUuidParcelleAppartement()).orElseThrow(null);
		
		parcelleAppartementVideo.setUuid(dto.getUuid());
		parcelleAppartementVideo.setVideo(video);
		parcelleAppartementVideo.setParcelleAppartemnt(parcelleAppartemnt);
		ParcelleAppartementVideo appartemntVideoSave = videoRepository.save(parcelleAppartementVideo);
		return Mapper.toParcelleAppartementVideoDto(appartemntVideoSave);
	}

	@Override
	public ParcelleAppartementVideoDto update(
			ParcelleAppartementVideoDto dto, String uuid) {
		// TODO Auto-generated method stub
		ParcelleAppartementVideo parcelleAppartemntVideo = videoRepository.findById(uuid).orElseThrow(null);
		StoredFile video = filesRepository.findById(dto.getUuidVideo()).orElseThrow(null);
		ParcelleAppartemnt parcelleAppartemnt = parcelleAppartemntRepository.findById(dto.getUuidParcelleAppartement()).orElseThrow(null);
		
		parcelleAppartemntVideo.setUuid(dto.getUuid());
		parcelleAppartemntVideo.setVideo(video);
		parcelleAppartemntVideo.setParcelleAppartemnt(parcelleAppartemnt);
		ParcelleAppartementVideo appartemntVideoSave = videoRepository.save(parcelleAppartemntVideo);
		return Mapper.toParcelleAppartementVideoDto(appartemntVideoSave);
	}

	@Override
	public List<ParcelleAppartementVideoDto> findAll() {
		// TODO Auto-generated method stub
		List<ParcelleAppartementVideo>  videos  = videoRepository.findAll();
		List<ParcelleAppartementVideoDto> videoDto = new ArrayList<ParcelleAppartementVideoDto>();
		videos.forEach(parcelle -> videoDto.add(Mapper.toParcelleAppartementVideoDto(parcelle)));
		return videoDto;
	}

	@Override
	public List<ParcelleAppartementVideoDto> findAllByParcelleAppartement(String uuid) {
		// TODO Auto-generated method stub
		List<ParcelleAppartementVideo> videos  = videoRepository.findAllVideoByParcelleAppartemnt(uuid);
		List<ParcelleAppartementVideoDto> videoDto = new ArrayList<>();
		videos.forEach(parcelle -> videoDto.add(Mapper.toParcelleAppartementVideoDto(parcelle)));
		return videoDto;
	}

	@Override
	public ParcelleAppartementVideoDto getParcelleAppartementVideo(String uuid) {
		//TODO Auto-generated method stub
		ParcelleAppartementVideo parcelleAppartementVideo = videoRepository.findById(uuid).orElseThrow(null);
		return Mapper.toParcelleAppartementVideoDto(parcelleAppartementVideo);
	}

	@Override
	public void deleteParcelleAppartementVideo(String uuid) {
		// TODO Auto-generated method stub
		videoRepository.deleteById(uuid);
	}

}
