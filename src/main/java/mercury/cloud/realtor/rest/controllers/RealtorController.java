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

import mercury.cloud.realtor.rest.entities.Realtor;
import mercury.cloud.realtor.rest.services.RealtorService;

@CrossOrigin(origins = "*")
@RestController
public class RealtorController {
	
	@Autowired
	private RealtorService realtorService;
	
	@GetMapping(value="/realtor/{id}")
	public Optional<Realtor> findById(@PathVariable("id") Integer id) {
		return realtorService.findById(id);
	}
	
	@PostMapping(value="/realtor")
	public Realtor save(@RequestBody Realtor realtor) {
		return realtorService.save(realtor);
	}
	
	@PutMapping(value="/realtor/{id}")
	public Realtor update(@RequestBody Realtor realtor, @PathVariable(value="id") int id) {
		realtor.setId(id);
		return realtorService.save(realtor);
	}
	
	@DeleteMapping(value="/realtor/{id}") 
	public void deleteById(@PathVariable("id") Integer id) {
		realtorService.deleteById(id);
	}
	
	@DeleteMapping(value="/realtor")
	public void delete(@RequestBody Realtor realtor) {
		realtorService.delete(realtor);
	}

}
