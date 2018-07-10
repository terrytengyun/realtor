package mercury.cloud.realtor.rest.daos;

import org.springframework.data.repository.CrudRepository;

import mercury.cloud.realtor.rest.daos.interfaces.CompanyInterface;
import mercury.cloud.realtor.rest.entities.Company;

public interface CompanyDao extends CrudRepository<Company, Integer>, CompanyInterface {

	public Company update(Company company);

}
