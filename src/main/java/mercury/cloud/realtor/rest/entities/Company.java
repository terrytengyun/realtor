package mercury.cloud.realtor.rest.entities;

import java.util.Set;

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

@Entity
@Table(name="company")
public class Company {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="name")
	private String name;
	
	@Column(name="logo")
	private String logo;
	
	@Embedded
	private CompanyContact companyContact;
	
	@Column(name="description", length=5000)
	private String description;
	
	@OneToMany
	@JoinTable(
		name="company_property_rel", 
		joinColumns= {@JoinColumn(name="company_id")}, 
		inverseJoinColumns= {@JoinColumn(name="property_id")}
	)
	private Set<Property> properties;
	
	@OneToMany
	@JoinTable(
		name="company_realtor_rel",
		joinColumns= {@JoinColumn(name="company_id")},
		inverseJoinColumns= {@JoinColumn(name="realtor_id")}
	)
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
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CompanyContact getCompanyContact() {
		return companyContact;
	}

	public void setCompanyContact(CompanyContact companyContact) {
		this.companyContact = companyContact;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Property> getProperties() {
		return properties;
	}

	public void setProperties(Set<Property> properties) {
		this.properties = properties;
	}

	public Set<RealtorProfile> getRealtors() {
		return realtors;
	}

	public void setRealtors(Set<RealtorProfile> realtors) {
		this.realtors = realtors;
	}


	
	
	
	
}
