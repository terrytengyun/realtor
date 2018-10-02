package mercury.cloud.realtor.rest.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="company")
@Setter
@Getter
public class Company {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public @Setter int id;

	@Column(name="name")
	private String name;
	
	@Column(name="logo")
	private String logo;
	
	@Embedded
	private CompanyContact companyContact;
	
	@Column(name="description", length=5000)
	private String description;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(
		name="company_property_rel", 
		joinColumns= {@JoinColumn(name="company_id")}, 
		inverseJoinColumns= {@JoinColumn(name="property_id")}
	)
	@JsonManagedReference
	private Set<Property> properties;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(
		name="company_realtor_rel",
		joinColumns= {@JoinColumn(name="company_id")},
		inverseJoinColumns= {@JoinColumn(name="realtor_id")}
	)
	@JsonManagedReference
	private Set<RealtorProfile> realtors;
	
	@ManyToMany
	@JoinTable(
		name="company_customer_rel",
		joinColumns= {@JoinColumn(name="company_id")},
		inverseJoinColumns= {@JoinColumn(name="customer_id")}
	)
	private Set<Customer> customers;
	
	@Column(name="status")
	private String status;
	
	
}
