package io.lightfeather.springtemplate;

/**
 * Initializes the Spring Boot application
 * 
 * @author Jonathan Wisniewski
 * @since  11-08-2021
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
		
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
