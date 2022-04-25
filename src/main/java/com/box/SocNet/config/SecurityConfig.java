package com.box.SocNet.config;

import com.box.SocNet.model.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration  // аннотация, указывающая, что класс объявляет один или несколько методов @Bean
                // и может обрабатываться контейнером Spring для создания определений компонентов
                // и запросов на обслуживание для этих компонентов во время выполнения.
@EnableWebSecurity // включает поддержку web security и обеспечивает интеграцию со Spring MVC
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.GET,"/users").hasAnyRole(Role.ADMIN.name(),Role.USER.name())
                .antMatchers(HttpMethod.POST,"/users").hasRole(Role.ADMIN.name())
                .antMatchers(HttpMethod.DELETE,"/users/**").hasRole(Role.ADMIN.name())
                .antMatchers(HttpMethod.PUT,"/users").hasRole(Role.ADMIN.name())
                .antMatchers(HttpMethod.GET, "/messages").hasAnyRole(Role.ADMIN.name(),Role.USER.name())
                .antMatchers(HttpMethod.POST,"/messages").hasRole(Role.ADMIN.name())
                .antMatchers(HttpMethod.DELETE,"/messages/**").hasRole(Role.ADMIN.name())
                .antMatchers(HttpMethod.PUT,"/messages").hasRole(Role.ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.builder()
                        .username("admin")
                        .password(passwordEncoder().encode("admin"))
                        .roles(Role.ADMIN.name())
                        .build(),
                User.builder()
                        .username("user")
                        .password(passwordEncoder().encode("user"))
                        .roles(Role.USER.name())
                        .build()
        );
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
