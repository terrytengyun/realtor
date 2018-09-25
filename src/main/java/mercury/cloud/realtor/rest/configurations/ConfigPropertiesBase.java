package mercury.cloud.realtor.rest.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;
import lombok.Setter;

@Configuration
@PropertySource("classpath:configBase.properties")
@ConfigurationProperties(prefix="base")
public class ConfigPropertiesBase {
	@Getter
	@Setter
	public class Storage {
		private String accessId;
		private String accessToken;
		private String bucket;
		private String path;
	}
	
	private Storage storage;

	public Storage getStorage() {
		if(this.storage == null) {
			this.storage = new Storage();
		}
		return this.storage;
	}
	
	
}
