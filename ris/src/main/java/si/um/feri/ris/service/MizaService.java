package si.um.feri.ris.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import si.um.feri.ris.models.Miza;
import si.um.feri.ris.repository.MizaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MizaService {
    @Autowired
    private MizaRepository mizaRepository;
    @ResponseBody
    public List<Miza> getAll() {
        return (List<Miza>) mizaRepository.findAll();
    }

    @ResponseBody
    public Optional<Miza> getById(Long id){
        return mizaRepository.findById(id);
    }


    public List<Miza> findByStatusAndTipMizeId(boolean status, Long tip_mize_miza_id) {
        return mizaRepository.findByStatusAndTipMizeId(status, tip_mize_miza_id);
    }
    public Miza createMiza(Miza miza){
        return mizaRepository.save(miza);
    }
    public void updateMiza(Long id, Miza novaMiza) {
        if (mizaRepository.existsById(id)) {
            novaMiza.setIdMiza(id);
            mizaRepository.save(novaMiza);
        }
    }

    public void deleteMiza(Long id) {
        mizaRepository.deleteById(id);
    }

    public List<Miza> pronadjiStoloveSaViseOdOdredjenogBrojaOsoba(int steviloOseb) {
        return mizaRepository.pronadjiStoloveSaViseOdOdredjenogBrojaOsoba(steviloOseb);
    }

    public List<Miza> findByStatus(boolean status){
        return mizaRepository.findAllByStatus(status);
    }

    public List<Miza> findByTipMize(String naziv){
        return mizaRepository.findByTipMize(naziv);
    }

    public List<Miza> findBystevOseb(boolean status){
        return mizaRepository.findByStevOseb(status);
    }

    public List<Miza> findBystevMiz(int steviloMiz){
        return mizaRepository.findByStevMiz(steviloMiz);
    }

}
