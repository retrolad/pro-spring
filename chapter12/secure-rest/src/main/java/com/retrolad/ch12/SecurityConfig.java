package com.retrolad.ch12;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

// Security Filter Chain
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    // Global AuthenticationManager
    @Autowired
    public void initialize(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("prospring")
                .password("prospring")
                .roles("REMOTE");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement()    // Allows only one user be authenticated at a time
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Never create HttpSession
                .and()
                .authorizeRequests()
                .antMatchers("/rest/**").hasRole("REMOTE")
                .antMatchers("/**").permitAll() // allow this url to anyone
                .anyRequest().authenticated()
                .and()
                .formLogin()    // Tell spring to provide registration form -> /login
                .and()
                .httpBasic()    // Support simple authentication via HTTP protocol
                .and()
                .csrf().disable();
    }
}
