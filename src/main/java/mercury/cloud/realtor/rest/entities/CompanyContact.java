package mercury.cloud.realtor.rest.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Setter
@Getter
public class CompanyContact extends Contact{

	@Column(name="contact_description")
	private String contactDescription;
	
	@Column(name="website")
	private String website;
	
	@Column(name="fax")
	private String fax;
	
	@Column(name="phone2")
	private String phone2;

	
	
}
