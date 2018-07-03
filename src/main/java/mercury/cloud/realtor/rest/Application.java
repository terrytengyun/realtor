package mercury.cloud.realtor.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.jdbc.config.annotation.EnableRdsInstance;

@SpringBootApplication
@EnableRdsInstance(dbInstanceIdentifier="${cloud.aws.rds.dbInstanceIdentifier}",password="${cloud.aws.rds.mercurycloud.password}")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
