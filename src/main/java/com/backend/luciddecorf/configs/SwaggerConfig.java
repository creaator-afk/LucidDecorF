// SwaggerConfig.java
    package com.backend.luciddecorf.configs;

    import org.springdoc.core.models.GroupedOpenApi;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import io.swagger.v3.oas.models.OpenAPI;
    import io.swagger.v3.oas.models.info.Info;

    @Configuration
    public class SwaggerConfig {

        @Bean
        public GroupedOpenApi api() {
            return GroupedOpenApi.builder()
                    .group("com.backend.luciddecorf.controller")
                    .pathsToMatch("/**")
                    .build();
        }

        @Bean
        public OpenAPI customOpenAPI() {
            return new OpenAPI()
                    .info(new Info().title("LucidDecor API")
                    .version("1.0")
                    .description("API documentation for LucidDecorF"));
        }
    }