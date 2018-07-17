package mercury.cloud.realtor.rest.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PropertyBasicField {

	@Column(name="MLS_NUMBER")
	private String mlsNumber;
	
	@Column(name="DESCRIPTION", length=2000)
	private String description;
	
	@Column(name="PROPERTY_TYPE")
	private String propertyType;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="THUMBNAIL")
	private String thumbnail;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="LISTING_PRICE")
	private String listingPrice;
	
	@Column(name="BED_COUNT")
	private int numBed;
	
	@Column(name="BATH_COUNT")
	private int numBath;
	
	@Column(name="SQUARE_FEET")
	private int squareFeet;
	
	@Column(name="featured")
	private boolean featured;

	public String getMlsNumber() {
		return mlsNumber;
	}

	public void setMlsNumber(String mlsNumber) {
		this.mlsNumber = mlsNumber;
	}
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getListingPrice() {
		return listingPrice;
	}

	public void setListingPrice(String listingPrice) {
		this.listingPrice = listingPrice;
	}

	public int getNumBed() {
		return numBed;
	}

	public void setNumBed(int numBed) {
		this.numBed = numBed;
	}

	public int getNumBath() {
		return numBath;
	}

	public void setNumBath(int numBath) {
		this.numBath = numBath;
	}

	public int getSquareFeet() {
		return squareFeet;
	}

	public void setSquareFeet(int squareFeet) {
		this.squareFeet = squareFeet;
	}

	public boolean isFeatured() {
		return featured;
	}

	public void setFeatured(boolean featured) {
		this.featured = featured;
	}
	
	
}
