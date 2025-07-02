package software.xdev.spring_repository_demo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.web.DefaultBearerTokenResolver;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Value( "${api.token}" )
	private String expectedToken;
	
	@Bean
	public SecurityFilterChain securityFilterChain( HttpSecurity http ) throws Exception {
		http
				.authorizeHttpRequests(
						( authorizeHttpRequests ) ->
								authorizeHttpRequests
										//Access swagger without authentification
										.requestMatchers(
												"/v3/api-docs/**",
												"/swagger-ui/**",
												"/swagger-ui.html"
										).permitAll()
										// Everything else only authenticated
										.anyRequest().authenticated()
				)
				.oauth2ResourceServer( oauth2 -> oauth2
						.bearerTokenResolver( new DefaultBearerTokenResolver() )
						.authenticationManagerResolver( request -> authenticationManager() )
				);
		return http.build();
	}
	
	@Bean
	public AuthenticationManager authenticationManager() {
		return authentication -> {
			String token = authentication.getCredentials().toString();
			
			if( expectedToken.equals( token ) ) {
				return new UsernamePasswordAuthenticationToken( "api-user", token, List.of() );
			}
			else {
				throw new BadCredentialsException( "Invalid token" );
			}
		};
	}
	
	
}