package mercury.cloud.realtor.rest.daos;

import org.springframework.data.repository.CrudRepository;

import mercury.cloud.realtor.rest.entities.Realtor;

public interface RealtorDao extends CrudRepository<Realtor, Integer> {

}
