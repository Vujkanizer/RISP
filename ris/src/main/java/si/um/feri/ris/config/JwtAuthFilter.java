//package si.um.feri.ris.config;
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//import si.um.feri.ris.service.UporabnikAuthService;
//
//import java.io.IOException;
//
//@Component
//public class JwtAuthFilter extends OncePerRequestFilter {
//
//    private final UporabnikAuthService userDetailsService;
//    private final ObjectMapper objectMapper;
//
//    public JwtAuthFilter(UporabnikAuthService userDetailsService, ObjectMapper objectMapper) {
//        this.userDetailsService = userDetailsService;
//        this.objectMapper = objectMapper;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//        try {
//            String authHeader = request.getHeader("Authorization");
//
//            System.out.println(authHeader);
//            String token = null;
//            String username = null;
//            if (authHeader != null && authHeader.startsWith("Bearer ")) {
//                System.out.println("udje ");
//                token = authHeader.substring(7);
//                System.out.println(token);
//                username = JwtHelper.extractUsername(token);
//                System.out.println(username);
//            }
//
//            System.out.println(username);
//
////      If the accessToken is null. It will pass the request to next filter in the chain.
////      Any login and signup requests will not have jwt token in their header, therefore they will be passed to next filter chain.
//            if (token == null) {
//                filterChain.doFilter(request, response);
//                return;
//            }
//
////       If any accessToken is present, then it will validate the token and then authenticate the request in security context
//            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//                if (JwtHelper.validateToken(token, userDetails)) {
//                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, null);
//                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//                }
//            }
//
//            filterChain.doFilter(request, response);
////        } catch (AccessDeniedException e) {
////            ApiErrorResponse errorResponse = new ApiErrorResponse(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
////            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
////            response.getWriter().write(toJson(errorResponse));
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//}