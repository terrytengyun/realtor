package mercury.cloud.realtor.rest.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PROPERTY")
public class Property {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="MLS_NUMBER")
	private String mlsNumber;
	
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
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true) // Cascading
	@JoinTable(
			name="PROPERTY_IMAGE_REL", 
			joinColumns=@JoinColumn(name="PROPERTY_ID"),
			inverseJoinColumns=@JoinColumn(name="IMAGE_ID")
			)
	private Collection<PropertyImage> images = new ArrayList<PropertyImage>();
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL) // Cascading
	@JoinTable(
			name="PROPERTY_CUSTOM_FIELD_REL",
			joinColumns=@JoinColumn(name="PROPERTY_ID"),
			inverseJoinColumns=@JoinColumn(name="FIELD_ID")
			)
	private Collection<PropertyCustomField> customFeilds = new ArrayList<PropertyCustomField>();
	
	
	
	
	

	public String getMlsNumber() {
		return mlsNumber;
	}
	public void setMlsNumber(String mlsNumber) {
		this.mlsNumber = mlsNumber;
	}
	public Collection<PropertyImage> getImages() {
		return images;
	}
	public void setImages(Collection<PropertyImage> images) {
		this.images = images;
	}
	public Collection<PropertyCustomField> getCustomFeilds() {
		return customFeilds;
	}
	public void setCustomFeilds(Collection<PropertyCustomField> customFeilds) {
		this.customFeilds = customFeilds;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	
	
	
}
