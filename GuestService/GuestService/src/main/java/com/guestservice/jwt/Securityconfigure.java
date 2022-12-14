package com.guestservice.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.guestservice.jwt.filters.JwtRequestFilter;
import com.guestservice.jwt.service.MyUserDetailsService;

@EnableWebSecurity
	public class Securityconfigure<myUserDetailsService> extends WebSecurityConfigurerAdapter{
		@Autowired
		private MyUserDetailsService myUserDetailsService;
		@Autowired
		private JwtRequestFilter jwtRequestFilter;
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(myUserDetailsService);
		}
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
	.authorizeRequests().antMatchers("/guest/reg","/guest/authenticate").permitAll().anyRequest().authenticated()
	.and().sessionManagement()
	.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		}
		@Override
		@Bean
		public AuthenticationManager authenticationManagerBean() throws Exception {
			// TODO Auto-generated method stub
			return super.authenticationManagerBean();
		}
		@Bean
		public PasswordEncoder passwordEncoder()
		{
			return NoOpPasswordEncoder.getInstance();

		}
	}



