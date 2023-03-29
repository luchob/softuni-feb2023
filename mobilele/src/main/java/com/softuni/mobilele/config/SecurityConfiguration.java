package com.softuni.mobilele.config;

import com.softuni.mobilele.repositories.UserRepository;
import com.softuni.mobilele.services.ApplicationUserDetailsService;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.DelegatingSecurityContextRepository;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.RequestAttributeSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http,
      SecurityContextRepository securityContextRepository) throws Exception {
    http.
        // defines which pages will be authorized
            authorizeHttpRequests().
        // allow access to all static files (images, CSS, js)
            requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll().
            requestMatchers(EndpointRequest.toAnyEndpoint()).permitAll().
        // the URL-s below are available for all users - logged in and anonymous
            requestMatchers("/", "/users/login", "/users/register", "/users/login-error", "/offers/*").permitAll().
        anyRequest().authenticated().
        and().
        // configure login with HTML form
            formLogin().
        loginPage("/users/login").
        // the names of the user name, password input fields in the custom login form
            usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY).
            passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY).
        // where do we go after login
            defaultSuccessUrl("/").//use true argument if you always want to go there, otherwise go to previous page
        failureForwardUrl("/users/login-error").
        and().logout().//configure logout
        logoutUrl("/users/logout").
        logoutSuccessUrl("/").//go to homepage after logout
        invalidateHttpSession(true).
        and().
        securityContext().
        securityContextRepository(securityContextRepository);

    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public UserDetailsService userDetailsService(UserRepository userRepository) {
    return new ApplicationUserDetailsService(userRepository);
  }

  @Bean
  public SecurityContextRepository securityContextRepository() {
    return new DelegatingSecurityContextRepository(
        new RequestAttributeSecurityContextRepository(),
        new HttpSessionSecurityContextRepository()
    );
  }

}
