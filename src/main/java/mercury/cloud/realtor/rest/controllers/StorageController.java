package mercury.cloud.realtor.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import mercury.cloud.realtor.rest.services.StorageService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value="/storage")
public class StorageController {
	
	@Autowired
	private StorageService storageService;
	
	@GetMapping(value="/file/{id}")
	public String test(@PathVariable(value="id") String id) {
		return this.storageService.getFile(id); 
	}
	
	@PostMapping(value="/file/{id}")
	public String upload(@RequestPart(value="file") MultipartFile file, @PathVariable(value="id") String id) {
		
		
		this.storageService.uploadFile(file, id);
		
		return null; //? result?
	}
	
	@PostMapping(value="/files/{id}")
	public String upload(@RequestPart(value="file") MultipartFile[] files, @PathVariable(value="id") String id) {
		
		
		this.storageService.uploadFiles(files, id);
		
		return null; //? result?
	}

}
