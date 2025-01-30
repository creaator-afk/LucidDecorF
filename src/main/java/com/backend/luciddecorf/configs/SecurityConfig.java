        package com.backend.luciddecorf.configs;

        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.security.config.Customizer;
        import org.springframework.security.config.annotation.web.builders.HttpSecurity;
        import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
        import org.springframework.security.web.SecurityFilterChain;

        @Configuration
        @EnableWebSecurity
        public class SecurityConfig {

            @Bean
            public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                    .authorizeRequests()
                        .requestMatchers("/**","/swagger-ui.html", "/v3/api-docs/**", "/swagger-ui/**").permitAll() // Exclude paths from authentication
                        .anyRequest().authenticated()
                    .and()
                    .httpBasic(Customizer.withDefaults()); // Enable basic authentication
                return http.build();
            }
        }