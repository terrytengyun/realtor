package mercury.cloud.realtor.rest.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CustomerContact {

	@Column(name="cell_phone")
	private String cellPhone;

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	
	
}
