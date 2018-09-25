package mercury.cloud.realtor.rest;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.jdbc.config.annotation.EnableRdsInstance;

//@SpringBootApplication
//@EnableRdsInstance(dbInstanceIdentifier="${cloud.aws.rds.dbInstanceIdentifier}",password="${cloud.aws.rds.mercurycloud.password}"	)
public class Application implements CommandLineRunner{

	@Autowired
	DataSource datasource;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void run(String... args) {
		System.out.println(" ************===========***************** " + datasource.toString());
	}

}
