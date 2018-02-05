package com.spring.example.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class JdbcSecurityConfig {
	
	public static final String USER_LOGIN = "SELECT email, password, '1' FROM user WHERE email = ?";
	
	public static final String USER_ROLE = "select email, 'ROLE_USER' from user where email = ?";
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder, PasswordEncoder passwordEncoder, DataSource dataSource) throws Exception {
		builder
			.jdbcAuthentication()
			.dataSource(dataSource)
			.passwordEncoder(passwordEncoder)
			.usersByUsernameQuery(USER_LOGIN)
			.authoritiesByUsernameQuery(USER_ROLE);
	}
}
