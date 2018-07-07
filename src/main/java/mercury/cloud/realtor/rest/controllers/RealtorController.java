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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mercury.cloud.realtor.rest.entities.RealtorProfile;
import mercury.cloud.realtor.rest.services.RealtorService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/realtor")
public class RealtorController {
	
	@Autowired
	private RealtorService realtorService;
	
	@GetMapping(value="/profile/{id}")
	public Optional<RealtorProfile> findProfileById(@PathVariable("id") Integer id) {
		return realtorService.findProfileById(id);
	}
	
	@PostMapping(value="/profile")
	public RealtorProfile save(@RequestBody RealtorProfile realtorProfile) {
		return realtorService.saveProfile(realtorProfile);
	}
	
	@PutMapping(value="/profile/{id}")
	public RealtorProfile update(@RequestBody RealtorProfile realtorProfile, @PathVariable(value="id") int id) {
		realtorProfile.setId(id);
		return realtorService.saveProfile(realtorProfile);
	}
	
	@DeleteMapping(value="/profile/{id}") 
	public void deleteById(@PathVariable("id") Integer id) {
		realtorService.deleteProfileById(id);
	}
	
	@DeleteMapping(value="/profile")
	public void delete(@RequestBody RealtorProfile realtorProfile) {
		realtorService.deleteProfile(realtorProfile);
	}

}
