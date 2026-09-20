@Controller
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .carf(csrf -> csrf.disable())
            .authorizeHttpRequest(auth -> auth
                .requestMatchers("/", "/index", "/iniciar-sesion", "/registro").permitAll()
                .requestMatchers("/crear-cuenta", "/autenticacion").permitAll()
                .requestMatchers("/static/**", "/css/**", "/js/**", "/images/**").permitAll()
                .requestMatchers("/", "/index", "/index.html", "/iniciar-sesion", "/iniciar-sesion.html", "/registro", "/registro.html").permitAll()
                .anyRequest().authenticated()
            );
        return http.build();
    }
}