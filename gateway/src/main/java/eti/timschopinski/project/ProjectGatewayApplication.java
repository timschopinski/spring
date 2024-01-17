package eti.timschopinski.project;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import java.util.Arrays;
import java.util.Collections;

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
	@Bean
	public CorsWebFilter corsWebFilter() {

		final CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.setAllowedOrigins(Collections.singletonList("*"));
		corsConfig.setMaxAge(3600L);
		corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT"));
		corsConfig.addAllowedHeader("*");

		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfig);

		return new CorsWebFilter(source);
	}
}
