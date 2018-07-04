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
	

	
	public void uploadFiles(MultipartFile[] files, String key) {

		if(files.length > 0 ) {

			int i = 0;
			for(MultipartFile file : files) {
					uploadFile(file, key+i);
					i++;
				}
		}
            
		
		
	}
	
	public void uploadFile(MultipartFile file, String key) {

					if(!file.isEmpty()) {
						
						ObjectMetadata metadata = new ObjectMetadata();
			            metadata.setContentType(file.getContentType());
						try {
							s3.putObject(this.bucket, key, file.getInputStream(), metadata);
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

		}
	
	public String getFile(String key) {
		S3Object file = s3.getObject(this.bucket, key);
		return null;
	}
	
	public void delete(String key) {
		s3.deleteObject(bucket, key);
	}
	

	
}
