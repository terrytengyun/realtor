package mercury.cloud.realtor.rest.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:configBase.properties")
@ConfigurationProperties(prefix="base")
public class ConfigPropertiesBase {
	
	public class Storage {
		private String accessId;
		private String accessToken;
		private String bucket;
		public String getAccessId() {
			return accessId;
		}
		public void setAccessId(String accessId) {
			this.accessId = accessId;
		}
		public String getAccessToken() {
			return accessToken;
		}
		public void setAccessToken(String accessToken) {
			this.accessToken = accessToken;
		}
		public String getBucket() {
			return bucket;
		}
		public void setBucket(String bucket) {
			this.bucket = bucket;
		}
		
	}
	
	private Storage storage;

	public Storage getStorage() {
		if(this.storage == null) {
			this.storage = new Storage();
		}
		return this.storage;
	}
	
	
}
