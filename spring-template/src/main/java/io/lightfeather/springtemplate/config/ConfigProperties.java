package io.lightfeather.springtemplate.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import io.lightfeather.springtemplate.util.RestTemplateResponseErrorHandler;

@Configuration
public class ConfigProperties {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	   return builder
			  .setConnectTimeout(Duration.ofMillis(3000))
              .setReadTimeout(Duration.ofMillis(3000))
              .errorHandler(new RestTemplateResponseErrorHandler())
              .build();
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
