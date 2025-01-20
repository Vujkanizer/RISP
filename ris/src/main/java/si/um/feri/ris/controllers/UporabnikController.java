package si.um.feri.ris.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import si.um.feri.ris.models.Uporabnik;
import si.um.feri.ris.requests.AddUporabnikRequest;
import si.um.feri.ris.service.UporabnikService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/uporabnik")
public class UporabnikController {
    private final UporabnikService uporabnikService;


    @Autowired
    public UporabnikController(UporabnikService uporabnikService) {
        this.uporabnikService = uporabnikService;
    }

    @GetMapping
    public List<Uporabnik> getALL() {
        return uporabnikService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Uporabnik> getById(@PathVariable("id") Integer id){
        return uporabnikService.getById(id);
    }


    @CrossOrigin
    @PostMapping("/add")
    public Uporabnik addUporabnik(@RequestBody AddUporabnikRequest uporabnik) {
        return uporabnikService.save(uporabnik);
    }

    @PostMapping("/login/{email}/{geslo}")
    public ResponseEntity<Map<String, String>> login(@PathVariable String email, @PathVariable String geslo, HttpServletResponse response) throws Exception {
        Uporabnik u = uporabnikService.authenticate(email, geslo);
        if (u != null) {
            Map<String, String> responseBody = new HashMap<>();
            responseBody.put("id", String.valueOf(u.getIdUporabnik()));
            responseBody.put("email", u.getEmail());
            responseBody.put("vrsta", u.getVrsta().toString());
            responseBody.put("message", "Uspješna prijava");
            return new ResponseEntity<>(responseBody, HttpStatus.OK);
        } else {
            Map<String, String> responseBody = new HashMap<>();
            responseBody.put("message", "Neuspješna prijava");
            return new ResponseEntity<>(responseBody, HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/email/{email}")
    public List<Uporabnik> findByEmail(@PathVariable String email){
        return uporabnikService.findByEmail(email);
    }

    @PutMapping("/{telefon}/{id}")
    public void updateProfil(@PathVariable int telefon, @PathVariable Long id){
        uporabnikService.updateProfil(telefon, id);
    }
}
