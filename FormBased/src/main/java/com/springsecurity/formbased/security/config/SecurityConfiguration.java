package com.springsecurity.formbased.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

/*
    private final PasswordEncoder passwordEncoder;
*/
    private final AuthenticationProvider authenticationProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth
                /*.inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder.encode("123"))*//*.roles("ADMIN")*//*.authorities("ROLE_ADMIN", "ACCESS_TEST1", "ACCESS_TEST2")
                .and()
                .withUser("manager").password(passwordEncoder.encode("123"))*//*.roles("MANAGER")*//*.authorities("ROLE_MANAGER", "ACCESS_TEST1")
                .and()
                .withUser("fnkaya").password(passwordEncoder.encode("123")).roles("USER");*/

                .authenticationProvider(authenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/index").permitAll()
                .antMatchers("/profile/**").authenticated()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/management/**").hasAnyRole("ADMIN", "MANAGER")
                .antMatchers("/api/public/test-1").hasAuthority("ACCESS_TEST1")
                .antMatchers("/api/public/test-2").hasAuthority("ACCESS_TEST2")
                .antMatchers("/api/public/users").hasAnyRole("ADMIN", "MANAGER")
                .antMatchers("/api/public/authorities").hasRole("ADMIN")
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
                .and()
                .rememberMe().tokenValiditySeconds(2592000).key("rm-key");
    }
}
