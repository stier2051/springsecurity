package mun.course.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) ->
                requests.requestMatchers(
                        "/myAccount",
                        "/myCards",
                        "/myBalance",
                        "/myLoans")
                        .authenticated());

        http.authorizeHttpRequests((requests) -> requests.requestMatchers("/notices", "/contact").permitAll());

        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    InMemoryUserDetailsManager userDetailsService() {

        /**
         * configuring users using InMemoryUserDetailsManager, Approach-1
         */
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("qwerty")
//                .authorities("admin")
//                .build();
//
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("qwerty")
//                .authorities("read")
//                .build();

        /**
         * configuring users using InMemoryUserDetailsManager, Approach-2
         */
        UserDetails admin = User.withUsername("admin")
                .password("qwerty")
                .authorities("admin")
                .build();

        UserDetails user = User.withUsername("user")
                .password("qwerty")
                .authorities("read")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
