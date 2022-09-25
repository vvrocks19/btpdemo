package com.anubhavtrainings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.anubhavtrainings.myclasses.Laptop;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		Laptop appleI80 = context.getBean(Laptop.class);
		appleI80.setBrandName("Apple");
		System.out.println(appleI80.toString());
		
		
	}

}
