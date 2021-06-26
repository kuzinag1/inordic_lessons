package ru.news.demoapp.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import ru.news.demoapp.model.Role;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                //.antMatchers("/").authenticated()
                .antMatchers("/").hasAnyAuthority("user:write")
                .antMatchers("/auth/login/**").anonymous()
                //.antMatchers("/login/**").anonymous()
                .and()
                .formLogin()
                .loginPage("/auth/login")
                .defaultSuccessUrl("/")
                .and()
                .rememberMe()
                .and()
                .logout()
                .logoutUrl("/logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID", "remember-me")
                .logoutSuccessUrl("/auth/login");


    }
    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(

                User.builder()
                .username("roman")
                .password(passwordEncoder().encode("root"))
                .authorities(Role.ADMIN.getAuthorities())
                .build(),

                User.builder()
                .username("mariia")
                .password(passwordEncoder().encode("123"))
                .authorities(Role.USER.getAuthorities())
                .build()
        );
    }
}
