package mercury.cloud.realtor.rest.services;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;

import lombok.Getter;
import lombok.Setter;
import mercury.cloud.realtor.rest.configurations.ConfigPropertiesBase;

@Service
@Getter
@Setter
public class StorageService {

	@Autowired
	private ConfigPropertiesBase config;
	
	
	@Autowired
	private AmazonS3 s3;
	
	@Value("${cloud.s3.bucket.prefix}")
	private String bucketPrefix;
	
	
	public StorageService() {
	}
	

	
	
	public Map<String,String> uploadFiles(int companyId, MultipartFile[] files, String key) {

		
		
		Map<String,String> urls = new HashMap<String, String>();
		String bucket = bucketPrefix + companyId;
		if(!s3.doesBucketExistV2(bucket)) {
			s3.createBucket(bucket);
		}
		if(files.length > 0 ) {
			String filename = "";
			int i = 0;
			for(MultipartFile file : files) {
					filename = key+"-"+i;
					uploadFile(companyId, file, filename);
					urls.put(filename, s3.getUrl(bucket, filename).toString());
					i++;
				}
		}
            
		return urls;
		
	}
	
	public String uploadFile(int companyId, MultipartFile file, String key) {
			String bucket = bucketPrefix + companyId;
			if(!s3.doesBucketExistV2(bucket)) {
				s3.createBucket(bucket);
			}
			if(!file.isEmpty()) {
				
				ObjectMetadata metadata = new ObjectMetadata();
	            metadata.setContentType(file.getContentType());
	           
				try {
					s3.putObject(bucket, key, file.getInputStream(), metadata);
					return s3.getUrl(bucket, key).toString();
					
					
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
			return null;
	}
	
	public String uploadFile(int companyId, File file, String key) {
		String bucket = bucketPrefix + companyId;
		if(!s3.doesBucketExistV2(bucket)) {
			s3.createBucket(bucket);
		}
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentType("image/jpeg");
		s3.putObject(bucket, key, file);
		return s3.getUrl(bucket, key).toString();

	}
	
	
	public String getFile(int companyId, String key) {
		String bucket = bucketPrefix + companyId;
		S3Object file = s3.getObject(bucket, key);
		return null;
	}
	
	public void delete(int companyId, String key) {
		String bucket = bucketPrefix + companyId;
		s3.deleteObject(bucket, key);
	}
	

	public static void resize(String inputImagePath,
			String outputImagePath, int scaledWidth, int scaledHeight)
			throws IOException {
		// reads input image
		File inputFile = new File(inputImagePath);
		BufferedImage inputImage = ImageIO.read(inputFile);

		// creates output image
		BufferedImage outputImage = new BufferedImage(scaledWidth,
				scaledHeight, inputImage.getType());

		// scales the input image to the output image
		Graphics2D g2d = outputImage.createGraphics();
		g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
		g2d.dispose();

		// extracts extension of output file
		String formatName = outputImagePath.substring(outputImagePath
				.lastIndexOf(".") + 1);

		// writes to output file
		ImageIO.write(outputImage, formatName, new File(outputImagePath));
	}
	
	public static void resize(String inputImagePath,
            String outputImagePath, double percent) throws IOException {
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);
        int scaledWidth = (int) (inputImage.getWidth() * percent);
        int scaledHeight = (int) (inputImage.getHeight() * percent);
        resize(inputImagePath, outputImagePath, scaledWidth, scaledHeight);
	}
	
	

	
}
