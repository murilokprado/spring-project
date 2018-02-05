package com.spring.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
			authorizeRequests()
				.antMatchers("/layout/**").permitAll()
				.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/enter")
				.permitAll()
			.and()
			.logout()
				.logoutSuccessUrl("/enter?logout")
				.permitAll();
	}
}
