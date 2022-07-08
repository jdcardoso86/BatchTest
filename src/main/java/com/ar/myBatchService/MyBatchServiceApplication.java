package com.ar.myBatchService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MyBatchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBatchServiceApplication.class, args);
	}

}
