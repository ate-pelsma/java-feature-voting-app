package com.projectfeaturevoting.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService users() {
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("welcome")) // welcome {bcrypt}$2a$10$AyCXUYa6mJ913D10qkE4turmvtyeM2fn8G.lVB05pUnbxr4sxmyQi
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("secret")) // secret
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests()
                    .requestMatchers("/").permitAll()
                    .anyRequest().hasRole("USER").and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/dashboard")
                    .permitAll()
                    .and()
                .logout()
                    .logoutUrl("/logout")
                    .permitAll();

        return http.build();
    }
}
