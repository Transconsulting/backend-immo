package com.immobilier.dto.client;

import java.util.Date;
import java.util.List;

import com.immobilier.dto.AgentDto;
import com.immobilier.dto.ParcelleApartemntDetailDto;
import com.immobilier.enumeration.TypeAnnonce;
import com.immobilier.model.Agent;

public class PropertyDto {
	private String id;
	private String title;
	private String desc;
	private String propertyType;
	private String propertyStatus; 
	private String city;
	private List<String> zipCode;
	private List<String>  neighborhood;
	private List<String>  street;
	private LocationDto location;
	private String formattedAddress;
	private List<String> features;
	private boolean featured;
	private PriceDto priceDollar;
	private PriceDto priceEuro;
	private int bedrooms;
	private int bathrooms;
	private int garages;
	private AreaDto area;
	private int yearBuilt;
	private int ratingsCount;
	private int ratingsValue;
	private AdditionalFeatureDto[] additionalFeatures;
	private List<GalleryDto> gallery;
	private PlanDto[] plans;
	private List<VideoDto> video;
	private String published;
	private String lastUpdate;
	private int views;
	private TypeAnnonce typeAnnonce;
	private List<ParcelleApartemntDetailDto> parcelleAppartementDetails;
	private Date dateCreated;
	private Date dateUpdated;
	private AgentDto agent;
	
	public PropertyDto() { 
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getPropertyStatus() {
		return propertyStatus;
	}

	public void setPropertyStatus(String propertyStatus) {
		this.propertyStatus = propertyStatus;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	

	public List<String> getZipCode() {
		return zipCode;
	}

	public void setZipCode(List<String> zipCode) {
		this.zipCode = zipCode;
	}

	public List<String> getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(List<String> neighborhood) {
		this.neighborhood = neighborhood;
	}

	public List<String> getStreet() {
		return street;
	}

	public void setStreet(List<String> street) {
		this.street = street;
	}

	public LocationDto getLocation() {
		return location;
	}

	public void setLocation(LocationDto location) {
		this.location = location;
	}

	public String getFormattedAddress() {
		return formattedAddress;
	}

	public void setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
	}

	public List<String> getFeatures() {
		return features;
	}

	public void setFeatures(List<String> features) {
		this.features = features;
	}

	public boolean isFeatured() {
		return featured;
	}

	public void setFeatured(boolean featured) {
		this.featured = featured;
	}

	public PriceDto getPriceDollar() {
		return priceDollar;
	}

	public void setPriceDollar(PriceDto priceDollar) {
		this.priceDollar = priceDollar;
	}

	public PriceDto getPriceEuro() {
		return priceEuro;
	}

	public void setPriceEuro(PriceDto priceEuro) {
		this.priceEuro = priceEuro;
	}
 
	public int getBedrooms() {
		return bedrooms;
	}

	public void setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
	}

	public int getBathrooms() {
		return bathrooms;
	}

	public void setBathrooms(int bathrooms) {
		this.bathrooms = bathrooms;
	}

	public int getGarages() {
		return garages;
	}

	public void setGarages(int garages) {
		this.garages = garages;
	}

	public AreaDto getArea() {
		return area;
	}

	public void setArea(AreaDto area) {
		this.area = area;
	}

	public int getYearBuilt() {
		return yearBuilt;
	}

	public void setYearBuilt(int yearBuilt) {
		this.yearBuilt = yearBuilt;
	}

	public int getRatingsCount() {
		return ratingsCount;
	}

	public void setRatingsCount(int ratingsCount) {
		this.ratingsCount = ratingsCount;
	}

	public int getRatingsValue() {
		return ratingsValue;
	}

	public void setRatingsValue(int ratingsValue) {
		this.ratingsValue = ratingsValue;
	}

	public AdditionalFeatureDto[] getAdditionalFeatures() {
		return additionalFeatures;
	}

	public void setAdditionalFeatures(AdditionalFeatureDto[] additionalFeatures) {
		this.additionalFeatures = additionalFeatures;
	}

	public List<GalleryDto> getGallery() {
		return gallery;
	}

	public void setGallery(List<GalleryDto> gallery) {
		this.gallery = gallery;
	}

	public PlanDto[] getPlans() {
		return plans;
	}

	public void setPlans(PlanDto[] plans) {
		this.plans = plans;
	}

	public List<VideoDto> getVideo() {
		return video;
	}

	public void setVideo(List<VideoDto> video) {
		this.video = video;
	}

	public String getPublished() {
		return published;
	}

	public void setPublished(String published) {
		this.published = published;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public TypeAnnonce getTypeAnnonce() {
		return typeAnnonce;
	}

	public void setTypeAnnonce(TypeAnnonce typeAnnonce) {
		this.typeAnnonce = typeAnnonce;
	}

	public List<ParcelleApartemntDetailDto> getParcelleAppartementDetails() {
		return parcelleAppartementDetails;
	}

	public void setParcelleAppartementDetails(List<ParcelleApartemntDetailDto> parcelleAppartementDetails) {
		this.parcelleAppartementDetails = parcelleAppartementDetails;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public AgentDto getAgent() {
		return agent;
	}

	public void setAgent(AgentDto agent) {
		this.agent = agent;
	}
 
}
