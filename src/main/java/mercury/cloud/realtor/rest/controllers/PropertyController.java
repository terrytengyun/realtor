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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import mercury.cloud.realtor.rest.entities.Property;
import mercury.cloud.realtor.rest.services.PropertyService;

@CrossOrigin(origins = "*")
@RestController
public class PropertyController {

	@Autowired
	private PropertyService propertyService;
	
	
	@GetMapping(value="/property/{id}")
	public Optional<Property> findById(@PathVariable(value="id") int id) {
		return this.propertyService.findById(id);
	}
	
	@PostMapping(value="/property")
	public Property save(
			@RequestParam(value="description") String description,
			@RequestParam(value="address") String address,
			@RequestParam(value="city") String city,
			@RequestParam(value="thumbnail") String thumbnail,
			@RequestParam(value="title") String title,
			@RequestParam(value="listingPrice") String listingPrice,
			@RequestParam(value="numBed") int numBed,
			@RequestParam(value="numBath") int numBath,
			@RequestParam(value="squareFeet") int squareFeet,
			@RequestParam(value="mlsNumber") String mlsNumber,
			@RequestParam(value="images") MultipartFile[] images){

		
		Property property = new Property();
		property.setAddress(address);
		property.setCity(city);
		property.setListingPrice(listingPrice);
		property.setThumbnail(thumbnail);
		property.setTitle(title);
		property.setNumBath(numBath);
		property.setNumBed(numBed);
		property.setSquareFeet(squareFeet);
		property.setMlsNumber(mlsNumber);
		
		
		return propertyService.saveWithImages(property, images);
		
		// store images in AWS storage first
		//return this.propertyService.save(property);
	}
	
	@PutMapping(value="/property/{id}")
	public Property update(@RequestBody Property property, @PathVariable int id) {
		// update images on AWS storage first 
		
		property.setId(id);
		return this.propertyService.save(property);
	}
	
	@DeleteMapping(value="/property/{id}")
	public void deleteById(@PathVariable int id){
		propertyService.deleteById(id);
		
	}
	
	@DeleteMapping(value="/property/{id}/image/{imageId}")
	public void deleteImage(@PathVariable(value="id") int id, @PathVariable(value="imageId") int imageId){
		propertyService.deleteImage(id, imageId);
	}
	
	
}
