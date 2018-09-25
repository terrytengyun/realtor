package mercury.cloud.realtor.rest.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Embeddable
public class RealtorProfileContact extends Contact {
	@Column(name="cellphone")
	private String cellPhone;

}
