package mercury.cloud.realtor.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import mercury.cloud.realtor.rest.configurations.ConfigPropertiesBase;

@Service
public class StorageService {

	@Autowired
	private ConfigPropertiesBase config;
	
	
	@Autowired
	private AmazonS3 s3;
	
	
	@Value("${cloud.aws.s3.bucket}")
	private String bucket;
	
	
	public StorageService() {
	}
	
	public void uploadFile() {
		
		this.s3.putObject(this.bucket, "xxxaaa", "Uploaded String Object");
	}
	
	public String testFunction() {
		return " -----------------------  "+config.getStorage().getAccessId()+"   "+config.getStorage().getAccessToken();
	}
	
}
