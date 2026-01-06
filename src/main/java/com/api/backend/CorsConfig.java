package com.api.backend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("https://app-notes-ensolvers.netlify.app/"); // Origen permitido
        config.addAllowedHeader("*"); // Permitir todos los headers
        config.addAllowedMethod("*"); // Permitir todos los métodos (GET, POST, etc.)
        config.setAllowCredentials(true); // Permitir envío de cookies y credenciales

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
