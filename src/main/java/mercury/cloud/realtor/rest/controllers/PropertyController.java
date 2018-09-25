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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import mercury.cloud.realtor.rest.entities.Property;
import mercury.cloud.realtor.rest.entities.PropertyBasicField;
import mercury.cloud.realtor.rest.services.PropertyService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/company/{companyId}")
public class PropertyController {

	@Autowired
	private PropertyService propertyService;
	
	
	@GetMapping(value="/property/{propertyId}")
	public Optional<Property> findById(@PathVariable(value="propertyId") int id) {
		return this.propertyService.findById(id);
	}
	
	@PostMapping(value="/property")
	public Property save(
			@RequestParam(value="description") String description,
			@RequestParam(value="address") String address,
			@RequestParam(value="city") String city,
			@RequestParam(value="title") String title,
			@RequestParam(value="listingPrice") String listingPrice,
			@RequestParam(value="numBed") int numBed,
			@RequestParam(value="numBath") int numBath,
			@RequestParam(value="squareFeet") int squareFeet,
			@RequestParam(value="mlsNumber") String mlsNumber,
			@RequestParam(value="images") MultipartFile[] images){

		
		Property property = new Property();
		PropertyBasicField propertyBasicField = new PropertyBasicField();
		propertyBasicField.setDescription(description);
		propertyBasicField.setAddress(address);
		propertyBasicField.setCity(city);
		propertyBasicField.setListingPrice(listingPrice);
		propertyBasicField.setTitle(title);
		propertyBasicField.setNumBath(numBath);
		propertyBasicField.setNumBed(numBed);
		propertyBasicField.setSquareFeet(squareFeet);
		propertyBasicField.setMlsNumber(mlsNumber);
		
		property.setPropertyBasicField(propertyBasicField);
		
		
		return propertyService.saveWithImages(property, images);
		
		// store images in AWS storage first
		//return this.propertyService.save(property);
	}
	
	@PutMapping(value="/property/{propertyId}")
	public Property update(@RequestBody Property property, @PathVariable(value="propertyId") int id) {
		// update images on AWS storage first 
		
		property.setId(id);
		return this.propertyService.save(property);
	}
	
	@DeleteMapping(value="/property/{id}")
	public void deleteById(@PathVariable int id){
		propertyService.deleteById(id);
		
	}
	
	@DeleteMapping(value="/property/{propertyId}/image/{imageId}")
	public void deleteImage(@PathVariable(value="propertyId") int id, @PathVariable(value="imageId") int imageId){
		propertyService.deleteImage(id, imageId);
	}
	
	
}
