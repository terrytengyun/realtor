package mercury.cloud.realtor.rest.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mercury.cloud.realtor.rest.entities.Company;
import mercury.cloud.realtor.rest.services.CompanyService;

@RestController
@CrossOrigin(origins = "*")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@PostMapping(value="/company")
	public Company save(@RequestBody Company company) {
		return companyService.save(company);
	}
	
	@GetMapping(value="/company/{id}")
	public Optional<Company> findById(@PathVariable(value="id") int id) {
		return companyService.findById(id);
	}
	
	@DeleteMapping(value="/company/{id}")
	public void deleteById(@PathVariable(value="id") int id) {
		companyService.deleteById(id);
	}
	
	@PutMapping(value="/company/{id}")
	public Company update(@RequestBody Company company, @PathVariable(value="id") int id) {
		company.setId(id);
		return companyService.update(company);
		
	}
}
