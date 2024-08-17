package com.security;

import org.springframework.context.annotation.*;
//import org.springframework.security.config.annotation.authentication.builders.*;  
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
@ComponentScan("com.security")
public class WebSecurityConfig implements WebMvcConfigurer {

	@Bean
	public UserDetailsService userDetailsService() throws Exception {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(
				User.withDefaultPasswordEncoder().username("adithya").password("adithya123").roles("USER").build());
		return manager;
	}

	protected void configure(HttpSecurity http) throws Exception {

		http.antMatcher("/").authorizeRequests().anyRequest().hasRole("ADMIN").and().httpBasic().and()  
        .logout()  
        .logoutUrl("/j_spring_security_logout")  
        .logoutSuccessUrl("/")  ;
		
		
		/* exampe configuration */
	/**	http
        .authorizeRequests()
          .antMatchers("/", "/home").permitAll() // (3)
          .anyRequest().authenticated() // (4)
          .and()
       .formLogin() // (5)
         .loginPage("/login") // (5)
         .permitAll()
         .and()
      .logout() // (6)
        .permitAll()
        .and()
      .httpBasic();**/
	}
}
