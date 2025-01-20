package si.um.feri.ris.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import si.um.feri.ris.models.Miza;
import si.um.feri.ris.service.MizaService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/miza")
public class MizaController {

    private final MizaService mizaService;

    public MizaController(MizaService mizaService) {
        this.mizaService = mizaService;
    }

    @Autowired
    public MizaService getMizaService() {
        return mizaService;
    }
    @GetMapping
    public List<Miza> getALL(){return mizaService.getAll();}

    @GetMapping("/{id}")
    public Optional<Miza> getById(@PathVariable("id") Long id){
        return mizaService.getById(id);
    }

    @PostMapping("/add")
    public Miza createMiza(@RequestBody  Miza miza){

        return mizaService.createMiza(miza);

    }
    @GetMapping("/dvap/{status}/{tip_mize_miza_id}")
    public List<Miza> getByStatusAndTipMizeId(@PathVariable boolean status, @PathVariable Long tip_mize_miza_id) {
        return mizaService.findByStatusAndTipMizeId(status, tip_mize_miza_id);
    }

    @PutMapping("/{id}")
    public void updateMiza(@PathVariable Long id,@RequestBody Miza novaMiza){

        mizaService.updateMiza(id, novaMiza);
    }

    @DeleteMapping("/del/{id}")
    public void deleteMiza(@PathVariable Long id) {

        mizaService.deleteMiza(id);
    }

    @GetMapping("/MizePoSteviluOseba/{steviloOseb}")
    public List<Miza> dobaviStolove(@PathVariable int steviloOseb) {
        return mizaService.pronadjiStoloveSaViseOdOdredjenogBrojaOsoba(steviloOseb);
    }

    @GetMapping("/status/{status}")
    public List<Miza> findByStatus(@PathVariable boolean status){
        return mizaService.findByStatus(status);
    }


    @GetMapping("/imemnad/{naziv}")
    public List<Miza> findByTipMize(@PathVariable String naziv){
        return mizaService.findByTipMize(naziv);
    }

    @GetMapping("/stevo/{status}")
    public List<Miza> findBystevOseb(@PathVariable boolean status){
        return mizaService.findBystevOseb(status);
    }

    @GetMapping("/stevm/{steviloMiz}")
    public List<Miza> findBystevMiz(@PathVariable int steviloMiz){
        return mizaService.findBystevMiz(steviloMiz);
    }









}
