package com.example.startup.Config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@OpenAPIDefinition(
        servers = {@Server(url = "/", description = "Default Server URL")},
        info = @io.swagger.v3.oas.annotations.info.Info(title = "Ba7be7nyyyyyy API",
                version = "${info.app.version}",
                description = "${info.app.description}",
                contact = @io.swagger.v3.oas.annotations.info.Contact(name = "${info.app.contact.name}",
                        email = "${info.app.contact.email}")))

public class SwaggerUIConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("spring")
                .packagesToScan("com.example.ExamYasmine")
                .build();
    }

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(infoAPI());
    }

    public Info infoAPI() {
        return new Info().title("SpringDoc-Demo")
                .description("booon")
                .contact(contactAPI());
    }

    public Contact contactAPI() {
        Contact contact = new Contact().name("Equipe ASI II")
                .email("*************@esprit.tn")
                .url("https://www.linkedin.com/in/**********/");
        return contact;
    }

    @Bean
    public GroupedOpenApi eventsPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Blocs Management API")
                .pathsToMatch("/**")
                .build();

    }


}
