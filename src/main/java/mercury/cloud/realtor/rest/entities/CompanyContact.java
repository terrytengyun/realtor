package mercury.cloud.realtor.rest.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CompanyContact extends Contact{

	@Column(name="contact_description")
	private String contactDescription;
	
	@Column(name="website")
	private String website;
	
	@Column(name="fax")
	private String fax;

	public String getContactDescription() {
		return contactDescription;
	}

	public void setContactDescription(String contactDescription) {
		this.contactDescription = contactDescription;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	
	
}
