package mercury.cloud.realtor.rest.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Setter
@Getter
public class PropertyBasicField {

	@Column(name="MLS_NUMBER")
	private String mlsNumber;
	
	@Column(name="DESCRIPTION", length=2000)
	private String description;
	
	@Column(name="PROPERTY_TYPE")
	private String propertyType;
	
	@Column(name="PROPERTY_STYLE")
	private String propertyStyle;
	
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
	

	

	
}
