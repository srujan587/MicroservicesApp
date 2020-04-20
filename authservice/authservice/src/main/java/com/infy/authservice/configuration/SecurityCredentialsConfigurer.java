package com.infy.authservice.configuration;

import java.util.Arrays;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.infy.authservice.filter.JwtUsernameAndPasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityCredentialsConfigurer extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	/*
	 * @Autowired private BCryptPasswordEncoder passwordEncoder;
	 */

	@Autowired
	private JwtConfig jwtConfig;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.exceptionHandling()
				.authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED)).and()
				.addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), jwtConfig))
				.authorizeRequests().antMatchers(HttpMethod.POST, jwtConfig.getUri()).permitAll().anyRequest()
				.authenticated();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
/*
 * auth.inMemoryAuthentication().withUser("srujan").password(passwordEncoder.
 * encode("srujan")) .authorities(Arrays.asList(new
 * SimpleGrantedAuthority("ROLE_USER"))).and().withUser("admin")
 * .password(passwordEncoder.encode("admin")) .authorities(Arrays.asList(new
 * SimpleGrantedAuthority("ROLE_ADMIN")));
 */
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean( name="jwtConfigSec")
	public JwtConfig jwtConfig() {
		return new JwtConfig();
	}

}
