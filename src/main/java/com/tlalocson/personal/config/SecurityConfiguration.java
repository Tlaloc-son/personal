package com.tlalocson.personal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.tlalocson.personal.service.impl.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	@Qualifier("usuarioService")
	private CustomUserDetailsService usuarioService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authManager) throws Exception{
		authManager.userDetailsService(usuarioService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/css/*","/imgs/*","/js/*")
			.permitAll()
		.anyRequest()
			.authenticated()
			.and()
		.formLogin().loginPage("/login")
			.loginProcessingUrl("/logincheck")
			.defaultSuccessUrl("/login/success")
			.usernameParameter("username")
			.passwordParameter("password")
			.permitAll()
			.and()
		.logout().logoutUrl("/logout")
			.logoutSuccessUrl("/login")
			.permitAll();		
	}
}
