package com.kashuba.onlinestore.service.config;


import com.kashuba.onlinestore.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
//@ComponentScan("service")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsServiceImpl customUserDetailsService;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) {
//        web.ignoring().antMatchers("/**");
        web.ignoring().antMatchers(HttpMethod.POST, "/api/users");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.PUT, "/api/users/**").hasAnyAuthority((Client.Role.ADMIN.name()),
                (Client.Role.ADMIN.name()), (Client.Role.CLIENT.name()))
                .antMatchers(HttpMethod.GET, "/api/users").hasAnyAuthority((Client.Role.ADMIN.name()), (Client.Role.ADMIN.name()))
                .antMatchers(HttpMethod.GET, "/api/users/profile").permitAll()
                .antMatchers("/api/users/{\\\\d+}/price").hasAnyAuthority((Client.Role.ADMIN.name()), (Client.Role.ADMIN.name()))

                .antMatchers(HttpMethod.POST, "/api/requests/vacation").hasAnyAuthority((Client.Role.ADMIN.name()),
                (Client.Role.ADMIN.name()))
                .antMatchers(HttpMethod.GET, "/api/requests").hasAnyAuthority((Client.Role.ADMIN.name()), (Client.Role.ADMIN.name()))
                .antMatchers(HttpMethod.PUT, "/api/requests/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/requests/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/requests/profile").permitAll()

                .antMatchers(HttpMethod.GET, "/api/records").hasAnyAuthority((Client.Role.ADMIN.name()), (Client.Role.ADMIN.name()))
                .antMatchers(HttpMethod.PUT, "/api/records/**").hasAnyAuthority((Client.Role.ADMIN.name()), (Client.Role.ADMIN.name()))
                .antMatchers(HttpMethod.POST, "/api/records/**").hasAnyAuthority((Client.Role.ADMIN.name()), (Client.Role.ADMIN.name()))
                .antMatchers(HttpMethod.GET, "/api/records/profile").permitAll()

                .antMatchers(HttpMethod.GET, "/api/appointments/**").permitAll()

                .antMatchers(HttpMethod.DELETE).hasAuthority((Client.Role.ADMIN.name()))

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
//\\\\\\\

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic();
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth)
//            throws Exception
//    {
//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password("{noop}password")
//                .roles("USER");
//    }


//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("password")
//                        .roles("CLIENT")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
