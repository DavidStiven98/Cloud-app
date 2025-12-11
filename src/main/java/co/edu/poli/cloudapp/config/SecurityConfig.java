package co.edu.poli.cloudapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import co.edu.poli.cloudapp.security.JwtAutheticationFilter;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtAutheticationFilter jwtFilter;

    public  SecurityConfig(JwtAutheticationFilter jwtfFilter){
        this.jwtFilter = jwtfFilter;
        }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
    throws Exception{
        http.csrf(csrf -> csrf.disable())
            .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
            .requestMatchers("/v3/api-docs/**","/swagger-ui/**","swagger-ui.html", "actuator/**", "/api/auth/**").permitAll()
            .anyRequest().authenticated()
            ).addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

            return http.build();
    }
}
