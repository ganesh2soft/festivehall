package com.aynavil.festivehall.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity(debug = true)
@EnableMethodSecurity
public class CustomerSecConfig {

 	@Autowired
	CustomerAuthProvider customerAuthProvider; 
	 
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			
		http.authorizeHttpRequests()
		.requestMatchers("/api/v1/booking/welcome/**").permitAll()
		.requestMatchers("/api/v1/booking/bookingreq").authenticated()
		.requestMatchers("/api/v1/customer/customerlogin").permitAll()
		.requestMatchers("/api/v1/availadmin/**").permitAll()
		.requestMatchers("/api/v1/availadmin/**").permitAll()
		.requestMatchers("/api/v1/adminhall/**").permitAll()
		.requestMatchers("/api/v1/booking/getbookingbycustid/{custid}").permitAll()
		.requestMatchers("/api/v1/booking/bookhalldetails").permitAll()
		.requestMatchers("/api/v1/customer/**").permitAll()
		.requestMatchers("/myoffers/**").permitAll()
		.requestMatchers("/actuator/mapping/**").permitAll()
		
		.requestMatchers("/actuator/**").permitAll()
		.requestMatchers("/actuator/health").permitAll()
		.requestMatchers("/actuator/beans/**").permitAll()		
		
		.requestMatchers("/signup").permitAll()
		.requestMatchers("/v2/api-docs",
				"/v3/api-docs/**",
				"/swagger-resources/configuration/ui",  
				"/swagger-resources/configuration/security", 
				"/webjars/**",
				"/swagger-ui.html","/swagger-ui/**").permitAll();
		http.httpBasic();
		http.cors();
		http.csrf(csrf -> csrf.disable());
		http.sessionManagement(sessionManagement ->
		  sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		return http.build();
		
	/*	http.httpBasic(Customizer.withDefaults());
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.csrf().disable(); //403forbidden error
		http.sessionManagement(sessionManagement ->
     	sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));     
		http.addFilterAfter(new JWTTokenGeneratorFilter(), BasicAuthenticationFilter.class);
		http.addFilterBefore(new JWTValidateFilter(), BasicAuthenticationFilter.class);
	*/	
		
	}
	@Bean
    public CorsFilter corsFilter()  {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:4200"); // this allows all origin
        config.addAllowedOrigin("http://localhost:8050/actuator"); //Testing purpose
        config.addAllowedHeader("*"); // this allows all headers
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
    //    config.setExposedHeaders(Arrays.asList("Authorization"));
        config.setMaxAge((long) 3600000);
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
	
	@Bean
	public AuthenticationManager authManager(HttpSecurity http) throws Exception {
		
		AuthenticationManagerBuilder authenticationManagerBuilder = http
				.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.authenticationProvider(customerAuthProvider);
		return authenticationManagerBuilder.build();
	}
	}
