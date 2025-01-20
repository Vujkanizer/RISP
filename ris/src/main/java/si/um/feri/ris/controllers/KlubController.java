package si.um.feri.ris.controllers;

import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import si.um.feri.ris.models.Klub;
import si.um.feri.ris.service.KlubService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/klub")
public class KlubController {

    private final KlubService klubService;

    @Autowired
    public KlubController(KlubService klubService) {
        this.klubService = klubService;
    }

    @GetMapping
    public List<Klub> dohvatiSveKlubove() {
        return klubService.dohvatiSveKlubove();
    }

    @GetMapping("/{id}")
    public Optional<Klub> dohvatiKlub(@PathVariable Long id) {
        return klubService.dohvatiKlubPoId(id);
    }

    @PostMapping("/add")
    public Klub spremiKlub(@RequestBody Klub klub) {
        return klubService.spremiKlub(klub);
    }

    @PutMapping("/{id}")
    public void azurirajKlub(@PathVariable Long id, @RequestBody Klub noviKlub) {
        klubService.azurirajKlub(id, noviKlub);
    }

    @DeleteMapping("/{id}")
    public void obrisiKlub(@PathVariable Long id) {
        klubService.obrisiKlub(id);
    }

    @GetMapping("/aktivni/{status}")
    public List<Klub> dohvatiAktivneKluboveZaTipKluba(@PathVariable boolean status) {
        return klubService.dohvatiAktivneKluboveZaTipKluba(status);
    }
    @PostMapping("/pdf")
    public ResponseEntity<Klub> createKlub(@RequestBody Klub klub) throws DocumentException, IOException {
        klubService.createKlubAndGeneratePdf(klub);
        return ResponseEntity.ok(klub);
    }

    @GetMapping("/status")
    public List<Klub> getAllByStatus(){
        return klubService.findByStatus();
    }

    @PutMapping()
    public ResponseEntity<Klub> updateStatus(Long id){
        return klubService.updateStatus(id);
    }
}
