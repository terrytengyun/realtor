package mercury.cloud.realtor.rest.daos;

import org.springframework.data.repository.CrudRepository;

import mercury.cloud.realtor.rest.entities.Property;

public interface PropertyDao extends CrudRepository<Property, Integer> {

}
