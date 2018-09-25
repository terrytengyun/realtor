package mercury.cloud.realtor.rest.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="property_image")
@Getter
@Setter
public class PropertyImage {

	
	public PropertyImage() {
		
	}
	
	
	
	public PropertyImage(String url, String bucket, String pathname, String description) {
		super();
		this.url = url;
		this.bucket = bucket;
		this.pathname = pathname;
		this.description = description;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	/*
	@Column(name="property_id")
	private int propertyId;
	*/
	
	@Column(name="url")
	private String url;
	
	@Column(name="bucket")
	private String bucket;
	
	@Column(name="path_name")
	private String pathname;
	
	@Column(name="description")
	private String description;
	
	
}
