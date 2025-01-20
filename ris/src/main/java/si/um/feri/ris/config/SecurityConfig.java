//package si.um.feri.ris.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.web.cors.CorsConfiguration;
//
//import si.um.feri.ris.service.UporabnikService;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//
//    @Bean
//    public AuthenticationManager authenticationManager() throws Exception {
//        return super.authenticationManager();
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception{
//        return http
//                .cors(cors -> cors.configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues()))
//                .csrf(AbstractHttpConfigurer::disable)
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers(HttpMethod.POST, "/uporabnik/login/**").permitAll()
//                        .requestMatchers(HttpMethod.POST, "/uporabnik/add/**").permitAll()
//                        .anyRequest().authenticated())
//                .authenticationManager(authenticationManager)
//                .build();
//    }
////
////    private final UporabnikAuthService userDetailsService;
////    private final JwtAuthFilter jwtAuthFilter;
////
////    public SecurityConfig(UporabnikAuthService userDetailsService, JwtAuthFilter jwtAuthFilter) {
////        this.userDetailsService = userDetailsService;
////        this.jwtAuthFilter = jwtAuthFilter;
////    }
////
////    @Bean
////    public PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
////
////    @Bean
////    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
////        return http
////                .cors(cors -> cors.configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues()))
////                .csrf(AbstractHttpConfigurer::disable)
////                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//////        Set permissions on endpoints
////                .authorizeHttpRequests(auth -> auth
//////            our public endpoints
////                        .requestMatchers(HttpMethod.POST, "/uporabnik/login/**").permitAll()
////                        .requestMatchers(HttpMethod.POST, "/uporabnik/add/**").permitAll()
//////            our private endpoints
////                        .anyRequest().authenticated())
////                .authenticationManager(authenticationManager)
////
//////        We need jwt filter before the UsernamePasswordAuthenticationFilter.
//////        Since we need every request to be authenticated before going through spring security filter.
//////        (UsernamePasswordAuthenticationFilter creates a UsernamePasswordAuthenticationToken from a username and password that are submitted in the HttpServletRequest.)
////                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
////                .build();
////    }
////
////    @Bean
////    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
////        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
////        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
////        return authenticationManagerBuilder.build();
////    }
//}
//
//
//
//
