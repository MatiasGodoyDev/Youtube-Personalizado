package ar.edu.centro8.td1.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class UserSecurity {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Desactivar CSRF si es una API REST
            .authorizeRequests()
                // Cambiar antMatchers por requestMatchers en Spring Security 3.x
                .requestMatchers(HttpMethod.POST, "/usuarios/crear").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/usuarios/editar/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/usuarios/eliminar/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/usuarios/listar").permitAll()
                .anyRequest().authenticated()
            .and()
            .httpBasic(); // Usar autenticación básica para las pruebas

        return http.build();
    }

    // Definir el UserDetailsService para autenticación en memoria
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            if ("admin".equals(username)) {
                return User.withUsername("admin")
                        .password(passwordEncoder().encode("adminpass"))
                        .roles("ADMIN")
                        .build();
            } else if ("user".equals(username)) {
                return User.withUsername("user")
                        .password(passwordEncoder().encode("userpass"))
                        .roles("USER")
                        .build();
            } else {
                throw new UsernameNotFoundException("Usuario no encontrado");
            }
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
