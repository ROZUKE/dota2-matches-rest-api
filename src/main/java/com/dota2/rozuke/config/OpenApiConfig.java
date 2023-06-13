package com.dota2.rozuke.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Rozuke",
                        url = "https://github.com/rozuke"
                ),
                description = "OpenApi documentation for my Dota 2 matches",
                title = "OpenApi My Dota 2 Matches",
                version = "1.0"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "https://localhost:8080/dota2matches/api/v1"
                )
        },
        security = {
                @SecurityRequirement(name = "Bearer Auth")
        }
)
@SecurityScheme(
        name = "Bearer Auth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
}
