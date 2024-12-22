package by.bsu.zxcola.gatewayservice.config;

import by.bsu.zxcola.gatewayservice.security.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;


@Configuration
public class GatewayConfig {
    @Autowired
    AuthenticationFilter authenticationFilter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("product-service-route", r -> r.path("/product/**", "/order/*")
                        .filters(f -> f.filter(authenticationFilter).stripPrefix(3))
                        .uri("lb://ProductService"))
                .route("marketplace-service-route", r -> r.path("/marketplace/**")
                        .filters(f -> f.filter(authenticationFilter).stripPrefix(3))
                        .uri("lb://marketplace-service"))
                .route("auth-service-route", r -> r.path("/auth/**")
                        .filters(f -> f.filter(authenticationFilter).stripPrefix(1))
                        .uri("lb://UserService"))
                .build();
    }
}