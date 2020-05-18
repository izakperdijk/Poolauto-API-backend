package com.poolauto.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@SpringBootApplication
public class BackendApplication {

	//static private String propertyFile = "poolautoAPI-Mock.properties";

	public static void main(String[] args) throws IOException {
/*
		if (args.length == 1) {
			propertyFile = args[0] + ".properties";
		} else if (args.length > 1) {
			throw new IllegalArgumentException(
					"Too many arguments. " +
					"Maximum of 1 argument (property filename) allowed"
			);
		}

		// Get and set URL properties (RDW / Wiremock)
		FileInputStream propFile = new FileInputStream(
						System.getProperty("user.home") +
						"/Desktop/" +
						propertyFile
						);

		Properties p = new Properties(System.getProperties());
		p.load(propFile);
		System.setProperties(p);
*/
		// Run application
		SpringApplication.run(BackendApplication.class, args);

	}

}
