package com.amir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import java.lang.reflect.Array;
import java.util.*;

@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class PaymentApplication {

	public static void main(String[] args) {

//		SpringApplication.run(PaymentApplication.class, args);


		ConfigurableApplicationContext run = SpringApplication.run(PaymentApplication.class, args);
		int i = 0;
		Set<String> set = new TreeSet<>();
		for (String s: run.getBeanDefinitionNames()) {
//			System.out.println(i + ", s = " + s);
			set.add(s);
			i++;
		}

		set.forEach(System.out::println);
	}

}
