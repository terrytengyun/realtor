package mercury.cloud.realtor.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mercury.cloud.realtor.rest.services.StorageService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value="/storage")
public class StorageController {
	
	@Autowired
	private StorageService storageService;
	
	@GetMapping(value="/test")
	public String test() {
		return this.storageService.testFunction(); 
	}
	
	@GetMapping(value="/test2")
	public void test2() {
		this.storageService.uploadFile(); 
	}

}
