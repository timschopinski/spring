package eti.timschopinski.directorapp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;


@SpringBootApplication
public class DirectorAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DirectorAppApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(@Value("http://localhost:8082") String baseUrl) {
		return new RestTemplateBuilder().rootUri(baseUrl).build();
	}
}
