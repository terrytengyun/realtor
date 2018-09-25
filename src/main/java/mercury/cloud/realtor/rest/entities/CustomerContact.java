package mercury.cloud.realtor.rest.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Setter
@Getter
public class CustomerContact extends Contact {

	@Column(name="cellphone")
	private String cellPhone;

	
}
