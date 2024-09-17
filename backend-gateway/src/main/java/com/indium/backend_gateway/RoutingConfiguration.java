package com.indium.backend_gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutingConfiguration {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // Route for uploading match data
                .route("uploadMatchData", r -> r.path("/api/cricket/upload")
                        .uri("http://host.docker.internal:30005"))

                // Route for fetching matches played by player
                .route("matchesByPlayer", r -> r.path("/api/cricket/matches/player/{playerName}")
                        .uri("http://host.docker.internal:30005"))

                // Route for fetching cumulative score of player
                .route("cumulativeScoreByPlayer", r -> r.path("/api/cricket/score/player/{playerName}")
                        .uri("http://host.docker.internal:30005"))

                // Route for fetching top batsmen with pagination
                .route("topBatsmen", r -> r.path("/api/cricket/batsmen/top")
                        .uri("http://host.docker.internal:30005"))

                // Route for fetching match scores by date
                .route("matchScoresByDate", r -> r.path("/api/cricket/matches/date/{date}")
                        .uri("http://host.docker.internal:30005"))
                .build();
    }
}
