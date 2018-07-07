package mercury.cloud.realtor.rest.daos;

import org.springframework.data.repository.CrudRepository;

import mercury.cloud.realtor.rest.entities.RealtorAccount;

public interface RealtorAccountDao extends CrudRepository<RealtorAccount, Integer> {

}
