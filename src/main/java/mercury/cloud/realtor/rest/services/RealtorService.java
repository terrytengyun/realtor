package mercury.cloud.realtor.rest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mercury.cloud.realtor.rest.daos.RealtorDao;
import mercury.cloud.realtor.rest.entities.Realtor;

@Service
public class RealtorService {
	
	@Autowired
	private RealtorDao realtorDao;
	
	public Realtor save(Realtor realtor) {
		return realtorDao.save(realtor);
	}
	
	public Optional<Realtor> findById(Integer id) {
		return realtorDao.findById(id);
	}
	
	public void deleteById(Integer id) {
		realtorDao.deleteById(id);
	}
	
	public void delete(Realtor realtor) {
		realtorDao.delete(realtor);
	}
	
	
}
