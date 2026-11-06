package com.klef.soa.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
@Configuration
public class SwaggerConfig
{
    @Bean
    public OpenAPI customOpenAPI()
    {
        return new OpenAPI()
                .info(new Info()
                        .title("ATM Management Service API")
                        .version("1.0")
                        .description("REST API Documentation for ATM Management")
                        .contact(new Contact()
                                .name("Vikas")
                                .email("vkas8799@gmail.com")));
    }
}