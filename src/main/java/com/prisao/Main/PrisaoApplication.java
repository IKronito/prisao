package com.prisao.Main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.prisao.Main")
public class PrisaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrisaoApplication.class, args);
	}

}
