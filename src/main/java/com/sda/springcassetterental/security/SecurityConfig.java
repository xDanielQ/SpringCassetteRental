package com.sda.springcassetterental.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails client = User.withDefaultPasswordEncoder()
                .username("client")
                .password("client")
                .roles("CLIENT")
                .build();
        UserDetails owner = User.withDefaultPasswordEncoder()
                .username("owner")
                .password("owner")
                .roles("OWNER")
                .build();
        return new InMemoryUserDetailsManager(client, owner);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and()
                .authorizeRequests()
                .antMatchers("/").permitAll().and()
                .authorizeRequests().antMatchers("/console/**").permitAll()
                .antMatchers(HttpMethod.GET, "/CasetteRental").permitAll()
                .antMatchers(HttpMethod.GET, "/CasetteRental/all").permitAll()
                .antMatchers(HttpMethod.POST, "/CassetteRental").hasRole("OWNER")
                .antMatchers(HttpMethod.PUT, "/CassetteRental").hasRole("OWNER")
                .antMatchers(HttpMethod.DELETE, "/CassetteRental").hasRole("OWNER")
                .anyRequest()
                .hasRole("ADMIN")
                .and()
                .formLogin().permitAll()
                .and()
                .httpBasic()
                .and()
                .logout().permitAll()
                .and()
                .csrf().disable();

        http.headers().frameOptions().disable();
    }
}
