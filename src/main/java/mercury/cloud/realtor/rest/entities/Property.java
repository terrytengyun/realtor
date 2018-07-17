package mercury.cloud.realtor.rest.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
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
	
	@Embedded
	private PropertyBasicField propertyBasicField;
	
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
	
	
	
	
	

	public PropertyBasicField getPropertyBasicField() {
		return propertyBasicField;
	}
	public void setPropertyBasicField(PropertyBasicField propertyBasicField) {
		this.propertyBasicField = propertyBasicField;
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
	
	
	
	
}
