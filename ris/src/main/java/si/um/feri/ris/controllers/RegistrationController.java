//package si.um.feri.ris.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/api/registration")
//public class RegistrationController {
//
//    private final RegistrationService registrationService;
//
//    @Autowired
//    public RegistrationController(RegistrationService registrationService) {
//        this.registrationService = registrationService;
//    }
//
//    @PostMapping
//    public ResponseEntity<String> registerUser(@RequestBody RegistrationRequest request) {
//        try {
//            registrationService.registerUser(request.getIme(), request.getPriimek(), request.getEmail(), request.getGeslo(), request.getVrsta());
//            return ResponseEntity.ok("User registered successfully");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        }
//    }
//}
