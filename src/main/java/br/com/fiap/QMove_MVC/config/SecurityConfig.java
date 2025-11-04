package br.com.fiap.QMove_MVC.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Desativa CSRF temporariamente (só se ainda não tem <input name="_csrf"> nos forms)
            .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(auth -> auth
                // Libera acesso às páginas públicas
                .requestMatchers("/", "/home", "/login", "/css/**", "/js/**", "/images/**").permitAll()

                // Somente ADMIN pode acessar funcionários
                .requestMatchers("/funcionarios/**").hasRole("ADMIN")

                // ADMIN e USER podem acessar setores
                .requestMatchers("/setores/**").hasAnyRole("ADMIN", "USER")

                // Qualquer outra rota precisa de login
                .anyRequest().authenticated()
            )

            .formLogin(form -> form
                .loginPage("/login")            // rota da página de login (deve existir em Controller)
                .defaultSuccessUrl("/home", true) // pra onde vai depois de logar
                .permitAll()
            )

            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            );

        return http.build();
    }
}
