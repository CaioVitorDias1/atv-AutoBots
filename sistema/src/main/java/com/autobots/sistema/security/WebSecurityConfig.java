package com.autobots.sistema.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

    
    final UserDetailsServiceImpl userDetailsService;

    public WebSecurityConfig (UserDetailsServiceImpl userDetailsService){
        this.userDetailsService = userDetailsService;
        }

    // @Override
    // protected void configure(HttpSecurity http) throws Exception {
    //     http
    //         .httpBasic()
    //         .and()
    //         .authorizeRequests()
    //         // .antMatchers(HttpMethod.GET, "/parking-spot/**").permitAll()
    //         // .antMatchers(HttpMethod.POST, "/parking-spot/**").hasRole("USER")
    //         // .antMatchers(HttpMethod.DELETE, "/parking-spot/**").hasRole("ADMIN")
    //         .anyRequest()
    //         .authenticated()
    //         .and()
    //         .csrf()
    //         .disable();
    // }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        .httpBasic()
        .and()
        .authorizeHttpRequests()
        //.requestMatchers(HttpMethod.POST, "/login**")
        //.antMatchers(HttpMethod.GET, "/parking-spot/**").permitAll()
        // .antMatchers(HttpMethod.POST, "/parking-spot/**").hasRole("USER")
        // .antMatchers(HttpMethod.DELETE, "/parking-spot/**").hasRole("ADMIN")
        //.permitAll()
        .anyRequest().permitAll()
        //.authenticated()
        .and()
        .csrf()
        .disable();
       
        return http.build();
    }

    // @Override
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //     auth
    //         .userDetailsService(userDetailsService)
    //         .passwordEncoder(passwordEncoder());
        
        
        
        // .inMemoryAuthentication()
        // .withUser("caio")
        // .password(passwordEncoder().encode("123"))
        // .roles("ADMIN", "USER")
        // .and()
        // .withUser("roger")
        // .password(passwordEncoder().encode("456"))
        // .roles("USER")
        // ;
    //}

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
}
