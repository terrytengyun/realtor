package mercury.cloud.realtor.rest.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;

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
	

	
	public PutObjectResult upload(MultipartFile file, String id) {
		
		PutObjectResult result = null;
		
		if(!file.isEmpty()) {

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(file.getContentType());
			try {
				result = s3.putObject(this.bucket, id, file.getInputStream(), metadata);
				
			} catch (AmazonServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SdkClientException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public String getFile(String id) {
		S3Object file = s3.getObject(this.bucket, id);
		return null;
	}
	

	
}
