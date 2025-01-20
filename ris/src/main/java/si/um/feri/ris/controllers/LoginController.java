//package si.um.feri.ris.controllers;
//
//import org.eclipse.jetty.security.LoginService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/api/login")
//public class LoginController {
//
//    private final LoginService loginService;
//
//    @Autowired
//    public LoginController(LoginService loginService) {
//        this.loginService = loginService;
//    }
//
//    @PostMapping
//    public ResponseEntity<String> loginUser(@RequestBody LoginRequest request) {
//        try {
//            // Implementirajte logiku za provjeru korisničkih podataka i prijavu
//            // loginService.loginUser(request.getEmail(), request.getPassword());
//
//            // Ako je prijava uspješna, možete vratiti odgovor s odgovarajućim statusom
//            return ResponseEntity.ok("User logged in successfully");
//        } catch (Exception e) {
//            // Ako prijava nije uspjela, vratite odgovor s odgovarajućim statusom i porukom o pogrešci
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: " + e.getMessage());
//        }
//    }
//}
//
