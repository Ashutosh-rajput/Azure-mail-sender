package com.trainingmug.practiceplatform.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "TrainingMug Practice Platform API",
                version = "1.0",
                description = "APIs for TrainingMug Practice Platform"),
        servers = {

                @Server(
                        url = "http://localhost:8080",
                        description = "Local server"
                ),
                @Server(
                        url = "https://stage.api.trainingmug.com",
                        description = "Staging Server"
                ),
                @Server(
                        url = "https://api.trainingmug.com",
                        description = "Production Server"
                ),
        }
)
@SecurityScheme(
        name = "JWT",
        description = "Bearer token",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT")
public class SwaggerConfig {
}
