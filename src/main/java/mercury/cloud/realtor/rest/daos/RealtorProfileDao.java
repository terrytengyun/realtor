package mercury.cloud.realtor.rest.daos;

import org.springframework.data.repository.CrudRepository;

import mercury.cloud.realtor.rest.entities.RealtorProfile;

public interface RealtorProfileDao extends CrudRepository<RealtorProfile, Integer> {

}
