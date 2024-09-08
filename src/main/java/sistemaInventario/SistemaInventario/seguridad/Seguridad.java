package sistemaInventario.SistemaInventario.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import sistemaInventario.SistemaInventario.servicio.UsuarioServicio;

@Configuration
public class Seguridad {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorizeRequests
                        -> authorizeRequests
                        .requestMatchers("/login", "/css/**", "/js/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(formLogin
                        -> formLogin
                        .loginPage("/login")
                        .defaultSuccessUrl("/inventario", true) //Redirige a inventario despues de loguearse
                        .failureUrl("/login?error=true")
                        .permitAll()
                )
                .logout(logout
                        -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout") // Redirección tras logout
                        .permitAll()
                )
                .exceptionHandling(exceptions
                        -> exceptions
                        .authenticationEntryPoint((request, response, authException) -> {
                            response.sendRedirect("/login");
                        })
                );
        return http.build();
    }
}
