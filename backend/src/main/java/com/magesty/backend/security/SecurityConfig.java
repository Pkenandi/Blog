package com.magesty.backend.security;

import com.magesty.backend.filter.AuthenticationFilter;
import com.magesty.backend.filter.AuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.http.SessionCreationPolicy.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.authorizeRequests().antMatchers( "/api/op/**","/api/token/refresh/**").permitAll();
        http.authorizeRequests().antMatchers(GET,"/api/admin/**").hasAnyAuthority("ROLE_ADMIN","ROLE_USER");
        http.authorizeRequests().antMatchers(POST,"/api/adresse/**").hasAnyAuthority("ROLE_ADMIN","ROLE_USER");
        http.authorizeRequests().antMatchers(POST,"/api/interest/**").hasAnyAuthority("ROLE_ADMIN","ROLE_USER");
        http.authorizeRequests().antMatchers(POST,"/api/skills/**").hasAnyAuthority("ROLE_ADMIN","ROLE_USER");
        http.authorizeRequests().antMatchers(POST,"/api/edu/**").hasAnyAuthority("ROLE_ADMIN","ROLE_USER");
        http.authorizeRequests().antMatchers(POST,"/api/experience/**").hasAnyAuthority("ROLE_ADMIN","ROLE_USER");
        http.authorizeRequests().antMatchers(POST,"/api/langue/**").hasAnyAuthority("ROLE_ADMIN","ROLE_USER");
        http.authorizeRequests().antMatchers(POST,"/api/profile/**").hasAnyAuthority("ROLE_ADMIN","ROLE_USER");
        http.authorizeRequests().antMatchers(POST,"/api/projet/**").hasAnyAuthority("ROLE_ADMIN","ROLE_USER");
        http.authorizeRequests().antMatchers(POST,"/api/media/**").hasAnyAuthority("ROLE_ADMIN","ROLE_USER");
        http.authorizeRequests().anyRequest().permitAll();
        http.addFilter(new AuthenticationFilter(authenticationManagerBean()));
        http.addFilterBefore(new AuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}