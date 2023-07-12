package com.immobilier.mapper.client;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.immobilier.dto.AgentDto;
import com.immobilier.dto.ParcelleApartemntDetailDto;
import com.immobilier.dto.client.GalleryDto;
import com.immobilier.dto.client.LocationDto;
import com.immobilier.dto.client.PriceDto;
import com.immobilier.dto.client.PropertyDto;
import com.immobilier.dto.client.VideoDto;
import com.immobilier.mapper.Mapper;
import com.immobilier.model.Agent;
import com.immobilier.model.ParcelleAppartementVideo;
import com.immobilier.model.ParcelleAppartemnt;
import com.immobilier.model.ParcelleAppartemntImage;

public class MapperClient {
	
	public static PropertyDto toPropertyDto(ParcelleAppartemnt appParcel) {
		List<String> val=new ArrayList<String>();
		String ville="",commune="",quartier="";
		
		PropertyDto dto=new PropertyDto();
		dto.setId(appParcel.getDomaine().getUuid());
		dto.setTitle(appParcel.getDomaine().getLibelle());
		dto.setPropertyType(appParcel.getDomaine().getType().toString());
		dto.setPropertyStatus(appParcel.getDomaine().getStatut().toString());
		dto.setDesc(appParcel.getAppDescription());
		
		ville=appParcel.getDomaine().getQuartier().getCommune().getVille().getNomVille();
		commune=appParcel.getDomaine().getQuartier().getCommune().getNomCommune();
		quartier=appParcel.getDomaine().getQuartier().getNomQuartier();
		dto.setCity(ville);
		val.add(ville);
		val.add(commune);
		val.add(quartier);
		dto.setNeighborhood(val); 
		dto.setStreet(val);
		
		LocationDto locationDto=new LocationDto();
		locationDto.setPropertyId(appParcel.getUuid());
		locationDto.setLat(appParcel.getDomaine().getLattitude());
		locationDto.setLng(appParcel.getDomaine().getLongitude());
		dto.setLocation(locationDto); 
		
		dto.setFeatured(true);
		
		PriceDto prix=new PriceDto();
		prix.setRent(appParcel.getPrix());
		prix.setSale(appParcel.getPrix()); 
		dto.setPriceDollar(prix);
		dto.setPriceEuro(prix);
		
		dto.setRatingsCount(3);
		dto.setRatingsValue(400);
		
		VideoDto video=new VideoDto();  
		List<VideoDto> listeVideo=new ArrayList<>();
		if (appParcel.getParcelleAppartementVideo()!=null) {
			appParcel.getParcelleAppartementVideo().forEach(obj->{  
				video.setId(obj.getUuid());
				video.setName(getVideoParcelle(obj));
				//video.setLink(getVideoParcelle(obj)); 
				listeVideo.add(video);
			});  
		} 
		dto.setVideo(listeVideo); 
		
		
		GalleryDto gallery=new GalleryDto();  
		List<GalleryDto> listeGallery=new ArrayList<>();
		if (appParcel.getParcelleAppartemntImage()!=null) {
			appParcel.getParcelleAppartemntImage().forEach(img->{  
				gallery.setId(img.getUuid());
				gallery.setBig(getImageParcelle(img));
				gallery.setMedium(getImageParcelle(img));
				gallery.setSmall(getImageParcelle(img)); 
				listeGallery.add(gallery);
			});  
		} 
		dto.setGallery(listeGallery); 
		
		dto.setTypeAnnonce(appParcel.getDomaine().getTypeAnonce());
		
		List<ParcelleApartemntDetailDto> parcelleAppDetail=new ArrayList<>();
		ParcelleApartemntDetailDto appParcelDetail=new ParcelleApartemntDetailDto();
		if (appParcel.getLstparcelleApartemntDetail()!=null) {
			appParcel.getLstparcelleApartemntDetail().forEach(app->{
				appParcelDetail.setLibelle(app.getLibelle());
				appParcelDetail.setSize(app.getSize());
				appParcelDetail.setSurface(app.getUnite()); 
			});
			parcelleAppDetail.add(appParcelDetail);			
		}
		dto.setDateCreated(appParcel.getDateCreated());
		dto.setDateUpdated(appParcel.getLastUpdated());
		dto.setParcelleAppartementDetails(parcelleAppDetail); 
		dto.setAgent(Mapper.toAgentDto(appParcel.getDomaine().getAgent()));
		return dto;
	}
	
	 
	public static String getImageParcelle(ParcelleAppartemntImage parcelleAppartemntImage) {  
		 byte[] encodeBase64 = Base64.getEncoder().encode(parcelleAppartemntImage.getImage().getBytes());
		    String base64Encoded;
			try {
				base64Encoded = new String(encodeBase64, "UTF-8");
				return "data:"+parcelleAppartemntImage.getImage().getType()+";base64,"+base64Encoded;
			} catch (UnsupportedEncodingException e) { 
				e.printStackTrace();
			}
		 return "";
	 }
	
	public static String getVideoParcelle(ParcelleAppartementVideo pAVideo) {  
		 byte[] encodeBase64 = Base64.getEncoder().encode(pAVideo.getVideo().getBytes());
		    String base64Encoded;
			try {
				base64Encoded = new String(encodeBase64, "UTF-8");
				return "data:"+pAVideo.getVideo().getType()+";base64,"+base64Encoded;
			} catch (UnsupportedEncodingException e) { 
				e.printStackTrace();
			}
		 return "";
	 }

}
