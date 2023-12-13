package com.mnu.platform.config;

import jakarta.servlet.DispatcherType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.thymeleaf.extras.springsecurity6.dialect.SpringSecurityDialect;

@Configuration
@EnableWebSecurity
@SpringBootApplication
public class SecurityConfig{
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	private static final String[] AUTH_WHITELIST = {
		"/assets/**", "/images/**", "/templates/**", "/resource/**","/home","/login", "signup"
	};

	@Bean
	public SpringSecurityDialect springSecurityDialect(){
		return new SpringSecurityDialect();
	}

	@Bean
	protected SecurityFilterChain config(HttpSecurity http) throws Exception {
		return http
				.csrf().disable()
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers("/login","/signup").anonymous()
//						.requestMatchers("/board/**").hasRole("COMPANY")
						.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
						.requestMatchers(AUTH_WHITELIST).permitAll()
						.anyRequest().authenticated())
				.formLogin(login -> login
						.loginPage("/login")
						.loginProcessingUrl("/login")
						.usernameParameter("email")
						.passwordParameter("password")
						.defaultSuccessUrl("/game",false)
						.permitAll(false))
				.logout(logout -> logout
						.logoutUrl("/logout")
						.invalidateHttpSession(true)
						.clearAuthentication(true)
						.logoutSuccessHandler((request, response, authentication) -> {
					response.sendRedirect("/home");// 로그아웃 시 권한 제거)
						}))
				.build();
	}

}
