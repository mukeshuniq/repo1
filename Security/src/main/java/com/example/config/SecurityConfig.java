package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	InMemoryUserDetailsManager db() {
		UserDetails u1 = User.withDefaultPasswordEncoder()
		.username("Abi")
		.password("abi123")
		.build();
		
		UserDetails u2 = User.withDefaultPasswordEncoder()
				.username("Krishna")
				.password("krish123")
				.build();
		
		UserDetails u3 = User.withDefaultPasswordEncoder()
				.username("Suresh")
				.password("sur123")
				.build();
		
		return new InMemoryUserDetailsManager(u1, u2, u3);
	}
	
	@Bean
	SecurityFilterChain secFltr(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(req -> req
				.requestMatchers("/loging", "/signup").permitAll()
				.anyRequest().authenticated())
		.formLogin(Customizer.withDefaults())
		.httpBasic(Customizer.withDefaults());
		
		return http.build();
		
	}

}
