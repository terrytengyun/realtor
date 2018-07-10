package mercury.cloud.realtor.rest.daos.impls;

import java.util.Optional;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import mercury.cloud.realtor.rest.daos.CompanyDao;
import mercury.cloud.realtor.rest.daos.interfaces.CompanyInterface;
import mercury.cloud.realtor.rest.entities.Company;

public class CompanyDaoImpl implements CompanyInterface{


	
	@Autowired
	private CompanyDao companyDao;
	
	@Override
	@Transactional
	public Company update(Company company) {
		
		return companyDao.save(company);
		
		/*
		Optional<Company> comp = companyDao.findById(company.getId());
		comp.ifPresent(consumer -> consumer.setName("xixixixxi")); 	
		return null;
		*/
	}


}
