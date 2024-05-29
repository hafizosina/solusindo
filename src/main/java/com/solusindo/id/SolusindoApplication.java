package com.solusindo.id;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.solusindo.id")
public class SolusindoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SolusindoApplication.class, args);
	}

}
