package com.test.ceshi01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = {"com.test.ceshi01.servlet","com.test.ceshi01.filter"})
public class Ceshi01Application {

	public static void main(String[] args) {
		SpringApplication.run(Ceshi01Application.class, args);
	}
}
