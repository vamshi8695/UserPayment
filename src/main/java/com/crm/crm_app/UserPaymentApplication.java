package com.crm.crm_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Tells Spring Boot this is the starting point of the app.
public class UserPaymentApplication {

	public static void main(String[] args) {
		// Spring Boot's main method: launches the server,
		// sets up Spring context, and starts your web app.

		SpringApplication.run(UserPaymentApplication.class, args);
	}

}
