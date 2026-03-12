package com.lpu.student.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
//		http.cors(c->{});
		http.cors(c->{});
		http.csrf((c)->c.disable());
		http.authorizeHttpRequests((req)->
		req.requestMatchers("/error","/upload/**").permitAll()
		.requestMatchers("/delete/**","/update/**","/save").hasRole("ADMIN")
		.requestMatchers("/find/**","/findAll/**","/download/**").hasAnyRole("ADMIN","USER")
		.anyRequest().authenticated());
		
		http.formLogin(Customizer.withDefaults());   //for giving the  inbuild form activates
		http.httpBasic(Customizer.withDefaults());   //to work in the postman  path->(authorization->basic-auth->user.password)
		
		return http.build();

	}
	
	//used for encrpting password
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	 @Bean
	    public CorsConfigurationSource corsConfigurationSource() {

		 CorsConfiguration config = new CorsConfiguration();
	        config.addAllowedOrigin("*");
	        config.addAllowedHeader("*");
	        config.addAllowedMethod("*");

	        UrlBasedCorsConfigurationSource source =
	                new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", config);

	        return source;
	    }

}
