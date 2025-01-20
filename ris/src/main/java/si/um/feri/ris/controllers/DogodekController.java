package si.um.feri.ris.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import si.um.feri.ris.models.Uporabnik;
import si.um.feri.ris.requests.AddDogodekRequest;
import si.um.feri.ris.models.Dogodek;
import si.um.feri.ris.service.DogodekService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/dogodek")
public class DogodekController {

    private final DogodekService dogodekService;

    @Autowired
    public DogodekController(DogodekService dogodekService) {
        this.dogodekService = dogodekService;
    }

    @GetMapping("/joj/{odobren}/{cenaVstopnice}")
    public List<Dogodek> findBydog(@PathVariable boolean odobren, @PathVariable Float cenaVstopnice) {
        return dogodekService.findBydog(odobren, cenaVstopnice);
    }

    @GetMapping("/cena/{cenaVstopnice}")
    public List<Dogodek> findByCena(@PathVariable Float cenaVstopnice) {
        return dogodekService.findByCenaVstopnice(cenaVstopnice);
    }

    @PostMapping("/add")
    public Dogodek findByCena(@RequestBody AddDogodekRequest dogodek) {
        return dogodekService.save(dogodek);
    }

    @GetMapping("/stmiz/{steviloMiz}")
    public List<Dogodek> findBySteviloMiz(@PathVariable int steviloMiz) {
        return dogodekService.findBySteviloMiz(steviloMiz);
    }

    @CrossOrigin
    @GetMapping("/odobren")
    public List<Dogodek> findAllByOdobren() {
        return dogodekService.findAllByOdobren();
    }

    @GetMapping("/{uporabnik_iduporabnik}")
    public List<Dogodek> findByidu(@PathVariable int uporabnik_iduporabnik) {
        return dogodekService.findByidu(uporabnik_iduporabnik);
    }


}
