package mercury.cloud.realtor.rest;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import mercury.cloud.realtor.rest.configurations.ConfigPropertiesBase;
import mercury.cloud.realtor.rest.services.StorageService;


public class StorageTest {

	@Bean
	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		StorageService storageService = ctx.getBean(StorageService.class);
		ConfigPropertiesBase baseProp = ctx.getBean(ConfigPropertiesBase.class);
		System.out.println("-------------------------------- ImagePath : "+ baseProp.getStorage().getPath());
		File p1img1 = new File("C:\\Development\\Companies\\Realtor\\propertyImages\\C4240111-1.JPG");
		//String name = storageService.uploadFile(p1img1, "testtesttesthahaha");
		//System.out.println("--------------------------------  uploaded file name : "+name);

	}

}
