package mercury.cloud.realtor.rest.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import mercury.cloud.realtor.rest.entities.Property;
import mercury.cloud.realtor.rest.entities.PropertyImage;
import mercury.cloud.realtor.rest.services.PropertyService;
import mercury.cloud.realtor.rest.services.StorageService;

@CrossOrigin(origins = "*")
@RestController
public class PropertyController {

	@Autowired
	private PropertyService propertyService;
	
	@Autowired
	private StorageService storageService;
	
	@GetMapping(value="/property/{id}")
	public Optional<Property> findById(@PathVariable(value="id") int id) {
		return this.propertyService.findById(id);
	}
	
	@PostMapping(value="/property")
	public Property save(@RequestParam(value="description") String desc, @RequestParam(value="imgs") MultipartFile[] imgs){
		
		for(MultipartFile image : imgs) {
			
		}
		
		// store images in AWS storage first
		//return this.propertyService.save(property);
		return null;
	}
	
	@PutMapping(value="/property/{id}")
	public Property update(@RequestBody Property property, @PathVariable int id) {
		// update images on AWS storage first 
		
		property.setId(id);
		return this.propertyService.save(property);
	}
	
	@DeleteMapping(value="/property/{id}")
	public void deleteById(@PathVariable int id){
		Optional<Property> deletedProperty = this.propertyService.findById(id);
		
		if(deletedProperty.isPresent()) {
		
			ArrayList<PropertyImage> images = (ArrayList<PropertyImage>) deletedProperty.get().getImages();
			
			//---- how to make them like a transaction?
			
			for(PropertyImage image : images) {
				this.storageService.delete(image.getPathname());
			}
			
			this.propertyService.deleteById(id);
		}
		
		
	}
	
	
}
