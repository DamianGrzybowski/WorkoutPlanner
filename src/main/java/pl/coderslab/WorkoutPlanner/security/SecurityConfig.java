package pl.coderslab.WorkoutPlanner.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import pl.coderslab.WorkoutPlanner.service.SpringDataUserDetailsService;

@Configuration
@EnableWebSecurity

@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void  configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/home/**").authenticated()
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/home")
                .and().logout().logoutUrl("/logout").clearAuthentication(true).invalidateHttpSession(true).logoutSuccessUrl("/login")
                .permitAll()
                .and().exceptionHandling().accessDeniedPage("/403");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SpringDataUserDetailsService customUserDetailsService() {
        return new SpringDataUserDetailsService();
    }


}
