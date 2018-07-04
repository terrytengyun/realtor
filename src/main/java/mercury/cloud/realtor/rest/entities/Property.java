package mercury.cloud.realtor.rest.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="property")
public class Property {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="property_type")
	private String propertyType;
	
	@Column(name="address")
	private String address;
	
	@Column(name="city")
	private String city;
	
	@Column(name="thumbnail")
	private String thumbnail;
	
	@Column(name="title")
	private String title;
	
	@Column(name="listing_price")
	private String listingPrice;
	
	@Column(name="bed_count")
	private int numBed;
	
	@Column(name="bath_count")
	private int numBath;
	
	@Column(name="square_feet")
	private int squareFeet;
	
	@OneToMany
	private Collection<PropertyImage> images = new ArrayList<PropertyImage>();
	
	
	
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
