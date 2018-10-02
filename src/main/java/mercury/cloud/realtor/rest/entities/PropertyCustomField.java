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
@Table(name="PROPERTY_CUSTOM_FIELD")
@Setter
@Getter
public class PropertyCustomField {
	
	public PropertyCustomField() {
		
	}
	
	public PropertyCustomField(String name, String value) {
		this.name = name;
		this.value = value;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="VALUE")
	private String value;
	
	@Column(name="CATEGORY")
	private String category;

}
