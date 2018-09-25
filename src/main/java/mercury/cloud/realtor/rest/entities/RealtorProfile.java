package mercury.cloud.realtor.rest.entities;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="realtor_profile")
public class RealtorProfile {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	@Column(name="last_name", nullable=false)
	private String lastName;
	
	
	@Column(name="office_phone")
	private String officePhone;
	
	@Embedded
	private RealtorProfileContact contact;
	
	@ManyToOne
	private Company company;
	
	
	@Column(name="description", length=100000)
	private String description;
	
	@Column(name="title")
	private String title;
	
	@Column(name="avatar")
	private String avatar;
	
	@Column(name="image")
	private String image;
	
	
}
