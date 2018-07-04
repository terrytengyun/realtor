package mercury.cloud.realtor.rest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mercury.cloud.realtor.rest.daos.PropertyDao;
import mercury.cloud.realtor.rest.entities.Property;

@Service
public class PropertyService {

	@Autowired
	private PropertyDao propertyDao;
	
	public Property save(Property property) {
		return this.propertyDao.save(property);
	}
	
	public Optional<Property> findById(int id) {
		return this.propertyDao.findById(id);
	}
	
	public void deleteById(int id) {
		this.propertyDao.deleteById(id);
	}
	
	public void delete(Property property) {
		this.propertyDao.delete(property);
	}
}
