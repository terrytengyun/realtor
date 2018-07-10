package mercury.cloud.realtor.rest.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="realtor_account")
public class RealtorAccount {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@OneToMany //cascading?
	@JoinTable(
		name="realtor_profile_rel",
		joinColumns= {@JoinColumn(name="account_id")},
		inverseJoinColumns= {@JoinColumn(name="profile_id")}
	)
	private Set<RealtorProfile> profiles;
	
	@Column(name="cell_phone", nullable=false)
	private String cellPhone;
	
	@Column(name="status")
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<RealtorProfile> getProfiles() {
		return profiles;
	}

	public void setProfiles(Set<RealtorProfile> profiles) {
		this.profiles = profiles;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	
	
	
	
}