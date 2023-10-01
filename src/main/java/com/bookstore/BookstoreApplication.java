package com.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication

public class BookstoreApplication {
	public String PORT=System.getenv("PORT");
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

}
