package com.anubhavtrainings;

import org.apache.olingo.odata2.api.ODataServiceFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

import com.anubhavtrainings.annotation.processor.MyODataServiceFactory;
import com.anubhavtrainings.entities.AddressOdataAgent;
import com.anubhavtrainings.entities.VendorODataAgent;

@SpringBootApplication(scanBasePackages = "com.anubhavtrainings")
@EnableJpaRepositories(basePackages = "com.anubhavtrainings")
@EntityScan(basePackages = "com.anubhavtrainings") 
@ServletComponentScan(basePackages = "com.anubhavtrainings")
@EnableAsync
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean(name="com.anubhavtrainings.processor.MyODataServiceFactory")
	public ODataServiceFactory getServiceFactory(){
		return new MyODataServiceFactory("com.anubhavtrainings");
	}
	
	@Bean(name="com.anubhavtrainings.entities.VendorODataAgent")
	public VendorODataAgent vendorODataAgent(){
		return new VendorODataAgent();
	}
	
	@Bean(name="com.anubhavtrainings.entities.addressODataAgent")
	public AddressOdataAgent addressODataAgent(){
		return new AddressOdataAgent();
	}

}
