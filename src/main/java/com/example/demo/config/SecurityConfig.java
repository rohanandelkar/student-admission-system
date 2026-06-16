package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // INTERVIEW POINT: The SecurityFilterChain acts as a firewall. 
    // It intercepts every HTTP request and checks if the user is allowed in.
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login", "/css/**", "/js/**").permitAll() // Let anyone see the login page
                .anyRequest().authenticated() // Lock down literally everything else
            )
            .formLogin(form -> form
                .loginPage("/login") // Tells Spring we have a custom HTML page for logging in
                .defaultSuccessUrl("/students", true) // Where to go after a successful login
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout") // Where to go after clicking logout
                .permitAll()
            );
            
        return http.build();
    }

    // INTERVIEW POINT: We are using "In-Memory" authentication here for simplicity.
    // In a massive enterprise app, you would fetch the user from MySQL instead!
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.withDefaultPasswordEncoder()
            .username("admin")
            .password("admin123") // The password to log in!
            .roles("ADMIN")
            .build();
            
        return new InMemoryUserDetailsManager(admin);
    }
}