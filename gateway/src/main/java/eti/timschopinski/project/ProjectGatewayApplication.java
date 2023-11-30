package eti.timschopinski.project;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.io.Console;

@SpringBootApplication
public class ProjectGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(
			RouteLocatorBuilder builder,
			@Value("${app.movie.url}") String movieUrl,
			@Value("${app.director.url}") String directorUrl,
			@Value("${app.gateway.host}") String host
	) {
		System.out.println(directorUrl);
		return builder
				.routes()
				.route("directors", route -> route
						.host(host)
						.and()
						.path(
								"/api/directors/{uuid}",
								"/api/directors"
						)
						.uri(directorUrl)
				)
				.route("movies", route -> route
						.host(host)
						.and()
						.path(
								"/api/movies",
								"/api/movies/**",
								"/api/directors/{uuid}/movies",
								"/api/directors/{uuid}/movies/**"
						)
						.uri(movieUrl)
				)
				.build();
	}
}
