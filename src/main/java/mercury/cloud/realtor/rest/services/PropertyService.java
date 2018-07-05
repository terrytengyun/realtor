package mercury.cloud.realtor.rest.services;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import mercury.cloud.realtor.rest.daos.PropertyDao;
import mercury.cloud.realtor.rest.entities.Property;
import mercury.cloud.realtor.rest.entities.PropertyImage;

@Service
public class PropertyService {

	@Autowired
	private PropertyDao propertyDao;
	
	@Autowired
	private StorageService storageService;
	
	public Property save(Property property) {
		return this.propertyDao.save(property);
	}
	
	public Property saveWithImages(Property property, MultipartFile[] images) {
		Map<String,String> imgs = storageService.uploadFiles(images, property.getMlsNumber());
		for(Map.Entry<String, String> entry : imgs.entrySet()) {
			PropertyImage propertyImage = new PropertyImage();
			propertyImage.setBucket(storageService.getBucket());
			propertyImage.setPathname(entry.getKey());
			propertyImage.setUrl(entry.getValue());
			property.getImages().add(propertyImage);
		}
		return save(property);	
	}
	
	public Optional<Property> findById(int id) {
		return this.propertyDao.findById(id);
	}
	
	public void deleteById(int id) {
		Optional<Property> deletedProperty = propertyDao.findById(id);
		if(deletedProperty.isPresent()) {
			Collection<PropertyImage> images =  deletedProperty.get().getImages();
			//---- how to make them like a transaction?
			for(PropertyImage image : images) {
				this.storageService.delete(image.getPathname());
			}
			this.propertyDao.deleteById(id);
		}
	}
	
	public void delete(Property property) {
		this.propertyDao.delete(property);
	}
	
	public void deleteImage(int propertyId, int imageId) {
		Optional<Property> property = propertyDao.findById(propertyId);
		if(property.isPresent()) {
			Collection<PropertyImage> images =  property.get().getImages();
			for(PropertyImage img : images) {
				if(img.getId() == imageId) {
					images.remove(img);
					storageService.delete(img.getPathname());
					break;
				}
			}
			
			propertyDao.save(property.get());
			
		}
	}
}
