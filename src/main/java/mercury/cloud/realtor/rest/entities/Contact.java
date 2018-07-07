package mercury.cloud.realtor.rest.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Embeddable
public class Contact {

	@Column(name="address")
	private String address;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="phone2")
	private String phone2;
	
}
