package com.academia.inicio;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@EnableWebSecurity
@Configuration
public class SecurityConfig{	
	//definición roles y usuarios
	@Bean
    public InMemoryUserDetailsManager userDetailsMemory() throws Exception{
		
		List <UserDetails> users = List.of(
					User.withUsername("user1")
					.password("{noop}user1")
					.roles("INVITADO")
					.build(),
					User.withUsername("user2")
					.password("{noop}user2")
					.roles("OPERADOR")
					.build(),
					User.withUsername("user3")
					.password("{noop}user3")
					.roles("ADMIN")
					.build(),
					User.withUsername("user4")
					.password("{noop}user4")
					.roles("OPERADOR","ADMIN")
					.build());
		
		return new InMemoryUserDetailsManager (users);
			
    }
	//acceso a recursos
    @Bean
    public SecurityFilterChain filterchain (HttpSecurity http) throws Exception{
    	http.csrf().disable()
    	.authorizeRequests()
    	.requestMatchers(HttpMethod.POST,"/newcurso").hasRole("ADMIN")
    	.requestMatchers(HttpMethod.DELETE).hasAnyRole("OPERADOR","ADMIN")
    	.requestMatchers(HttpMethod.PUT).hasAnyRole("OPERADOR","ADMIN")
    	.requestMatchers(HttpMethod.GET).authenticated()
    	.and()
    	.httpBasic();
    	
    	
    	return http.build();
    }
	    
}
