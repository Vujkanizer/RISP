package si.um.feri.ris.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import si.um.feri.ris.models.Miza;
import si.um.feri.ris.models.Vstopnice;
import si.um.feri.ris.service.MizaService;
import si.um.feri.ris.service.VstopniceService;


import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin
@RequestMapping("/vstopnica")
public class VstopniceController {
    @Autowired
    private VstopniceService vstopniceService;
    @GetMapping("/UporabnikPoCeni/{cena}")
    public List<Vstopnice> dobaviKorisnike(@PathVariable int cena) {
        return vstopniceService.pronadjiKorisnikeSaCenomVstopnice(cena);
    }

    @GetMapping("/cena/{cena}")
    public List<Vstopnice> findByCena(@PathVariable float cena){
        return vstopniceService.findByCena(cena);
    }
}
