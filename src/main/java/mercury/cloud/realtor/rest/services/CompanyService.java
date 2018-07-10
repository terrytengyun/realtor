package mercury.cloud.realtor.rest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mercury.cloud.realtor.rest.daos.CompanyDao;
import mercury.cloud.realtor.rest.entities.Company;

@Service
public class CompanyService {

	@Autowired
	private CompanyDao companyDao;
	
	public Company save(Company company) {
		return companyDao.save(company);
	}
	
	public Optional<Company> findById(int id) {
		return companyDao.findById(id);
	}
	
	public void deleteById(int id) {
		companyDao.deleteById(id);
	}
	
	public void delete(Company company) {
		companyDao.delete(company);
	}
	
	public Company update(Company company) {
		return companyDao.update(company);
	}
}
