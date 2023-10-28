package com.yuhan.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Autowired
	private DataSource dataSource;
	
	/*
	 * requestMatchers : 접근권한에 대한 권한설정
	 * public, css 등은 접근권한을 주지않아 로그인하지않아도 접근 가능
	 * admin 은 hasRole 을 사용해 어드민만 사용가능하게 권한설정
	 * 그 외는 로그인 후 접근가능 
	 */
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/", "/public/**", "/css/**", "/resources/**", "/layouts/**", "/fragments/**", "/img/**", "/error", "/mail").permitAll()
				.requestMatchers("/admin/**").hasRole("ADMIN") //hasRole 사용시 ADMIN 앞에 ROLE_ 이 자동으로 붙음 ※ROLE_USER, ROLE_ADMIN
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/public/login")
				.permitAll()
			)
			.logout((logout) -> logout.permitAll());
		
		
		return http.build();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) 
	  throws Exception {
	    auth.jdbcAuthentication()
	      .dataSource(dataSource)
	      .usersByUsernameQuery("select username, password, enabled "
	  	        + "from user "
		        + "where username = ?")
		      .authoritiesByUsernameQuery("select u.username, r.name "
		        + "from user_role ur inner join user u on ur.id = u.id "
		        + "inner join role r on ur.role_id = r.id "
		        + "where u.username = ?");
	    
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
}