package io.lightfeather.springtemplate.bootloader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@RestController
public class Application {

  @RequestMapping("/")
  public String home() {
	  return "Hello World";
  }
		
  @Bean
  public WebClient.Builder getWebClientBuilder() {
	 return WebClient.builder();
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
