package com.kian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
//@ImportResource("classpath:applicationContext.xml")
public class CardApplication {

    public static void main(String[] args) {

        SpringApplication.run(CardApplication.class, args);
//		ConfigurableApplicationContext run = SpringApplication.run(PaymentApplication.class, args);
//		for (String s: run.getBeanDefinitionNames()) {
//			System.out.println("s = " + s);
//		}

    }

}
