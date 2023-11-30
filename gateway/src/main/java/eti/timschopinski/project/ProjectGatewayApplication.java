package eti.mecka.franciszek.project;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjectGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(
			RouteLocatorBuilder builder,
			@Value("${app.director.url}") String playerUrl,
			@Value("${app.movie.url}") String professionUrl,
			@Value("${app.gateway.host}") String host
	) {
		return builder
				.routes()
				.route("directors", route -> route
						.host(host)
						.and()
						.path(
								"/api/directors/{uuid}",
								"/api/directors"
						)
						.uri(professionUrl)
				)
				.route("movies", route -> route
						.host(host)
						.and()
						.path(
								"/api/movies",
								"/api/movies/**",
//								"/api/organizations/{uuid}/players",
//								"/api/organizations/{uuid}/players/**"
						)
						.uri(playerUrl)
				)
				.build();
	}
}
