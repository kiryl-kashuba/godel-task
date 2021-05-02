package com.kashuba.onlinestore.config;

import com.kashuba.onlinestore.entity.Client;
import com.kashuba.onlinestore.security.impl.CustomUserDetailsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
@Configuration
@EnableWebSecurity
@ComponentScan("com.kashuba.onlinestore.security")
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsServiceImpl customUserDetailsService;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) {
//        web.ignoring().antMatchers("/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/clients/**").hasAnyAuthority(Client.Role.ADMIN.name())
                .antMatchers(HttpMethod.DELETE, "/clients/**").hasAnyAuthority(Client.Role.ADMIN.name())
                .antMatchers(HttpMethod.POST, "/clients/**").permitAll()

                .antMatchers(HttpMethod.GET, "/carts/**").hasAnyAuthority(Client.Role.ADMIN.name())
                .antMatchers(HttpMethod.DELETE, "/carts/**").hasAnyAuthority(Client.Role.ADMIN.name())
                .antMatchers(HttpMethod.POST, "/carts/**").hasAnyAuthority(Client.Role.ADMIN.name())

                .antMatchers(HttpMethod.GET, "/categories/**").hasAnyAuthority(Client.Role.ADMIN.name(), Client.Role.CLIENT.name())
                .antMatchers(HttpMethod.DELETE, "/categories/**").hasAnyAuthority(Client.Role.ADMIN.name())
                .antMatchers(HttpMethod.POST, "/categories/**").hasAnyAuthority(Client.Role.ADMIN.name())

                .antMatchers(HttpMethod.GET, "/instance-products/**").hasAnyAuthority(Client.Role.ADMIN.name(), Client.Role.CLIENT.name())
                .antMatchers(HttpMethod.DELETE, "/instance-products/**").hasAnyAuthority(Client.Role.ADMIN.name())
                .antMatchers(HttpMethod.POST, "/instance-products/to-cart").hasAnyAuthority(Client.Role.ADMIN.name(), Client.Role.CLIENT.name())
                .antMatchers(HttpMethod.POST, "/instance-products/**").hasAnyAuthority(Client.Role.ADMIN.name())

                .antMatchers(HttpMethod.GET, "/order/**").hasAnyAuthority(Client.Role.ADMIN.name())
                .antMatchers(HttpMethod.DELETE, "/order/**").hasAnyAuthority(Client.Role.ADMIN.name())
                .antMatchers(HttpMethod.POST, "/order/**").hasAnyAuthority(Client.Role.ADMIN.name(), Client.Role.CLIENT.name())

                .antMatchers(HttpMethod.GET, "/product-attributes/**").hasAnyAuthority(Client.Role.ADMIN.name(), Client.Role.CLIENT.name())
                .antMatchers(HttpMethod.DELETE, "/product-attributes/**").hasAnyAuthority(Client.Role.ADMIN.name())
                .antMatchers(HttpMethod.POST, "/product-attributes/**").hasAnyAuthority(Client.Role.ADMIN.name())

                .antMatchers(HttpMethod.GET, "/product-attribute-values/**").hasAnyAuthority(Client.Role.ADMIN.name())
                .antMatchers(HttpMethod.DELETE, "/product-attribute-values/**").hasAnyAuthority(Client.Role.ADMIN.name())
                .antMatchers(HttpMethod.POST, "/product-attribute-values/**").hasAnyAuthority(Client.Role.ADMIN.name())

                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
