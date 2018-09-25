package mercury.cloud.realtor.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import mercury.cloud.realtor.rest.services.StorageService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value="/company/{companyId}/storage")
public class StorageController {
	
	@Autowired
	private StorageService storageService;
	
	@GetMapping(value="/file/{id}")
	public String test(@PathVariable(value="companyId") String companyId, @PathVariable(value="id") String id) {
		return this.storageService.getFile(Integer.parseInt(companyId), id); 
	}
	
	@PostMapping(value="/file/{id}")
	public String upload(@RequestPart(value="file") MultipartFile file,@PathVariable(value="companyId") String companyId, @PathVariable(value="id") String id) {
		
		
		this.storageService.uploadFile(Integer.parseInt(companyId),file, id);
		
		return null; //? result?
	}
	
	@PostMapping("/test")
	public String test2(@RequestParam("tttte") String ttttevalue,
					    @RequestPart("mypic") MultipartFile file,
					    @PathVariable(value="companyId") String companyId) {
		this.storageService.uploadFile(Integer.parseInt(companyId), file, ttttevalue);
		return ttttevalue;
	}
	
	@PostMapping(value="/files/{id}")
	public String upload(@RequestPart(value="file") MultipartFile[] files,@PathVariable(value="companyId") String companyId, @PathVariable(value="id") String id) {
		
		
		this.storageService.uploadFiles( Integer.parseInt(companyId), files, id);
		
		return null; //? result?
	}

}
