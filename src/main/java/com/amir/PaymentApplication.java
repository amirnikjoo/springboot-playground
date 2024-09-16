package com.amir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class PaymentApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext run = SpringApplication.run(PaymentApplication.class, args);
		for (String s: run.getBeanDefinitionNames()) {
			System.out.println("s = " + s);
		}

	}

}
