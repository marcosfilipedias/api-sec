package com.personal.apisecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.personal.apisecurity.jwt.JWTAuthorizationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	//TODO: VERIFICAR URLS PUBLICAS.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
        .authorizeRequests()
        .antMatchers(
      		  "*/public/*",
                "/v2/api-docs", 
                "/swagger-resources/**",  
                "/swagger-ui.html", 
                "/webjars/**" ,
                "/swagger.json").permitAll()
        .anyRequest().authenticated()
        .and()
        .addFilter(jwtBasicAuthenticationFilter())
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Bean
	private JWTAuthorizationFilter jwtBasicAuthenticationFilter() throws Exception {
		return new JWTAuthorizationFilter(authenticationManager());
	}
}
