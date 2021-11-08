package io.lightfeather.springtemplate.config;

/**
 * Configuration Properties
 * 
 * @author Jonathan Wisniewski
 * @since  11-08-2021
 */

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import io.lightfeather.springtemplate.util.UserValidator;

@Configuration
public class ConfigProperties {
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	   return builder
			  .setConnectTimeout(Duration.ofMillis(3000))
              .setReadTimeout(Duration.ofMillis(3000))
              .build();
	}
	
    @Bean
    UserValidator validator() {
        return new UserValidator();
    }

	@Value("${io.lightfeather.get.supervisor.endpoint}")
	private String allSupervisorsUrlGet;

	public String getAllSupervisorsUrlGet() {
		return allSupervisorsUrlGet;
	}

	public void setAllSupervisorsUrlGet(String allSupervisorsUrlGet) {
		this.allSupervisorsUrlGet = allSupervisorsUrlGet;
	}
}
