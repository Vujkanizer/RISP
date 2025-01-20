package si.um.feri.ris.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import si.um.feri.ris.models.Vstopnice;
import si.um.feri.ris.repository.VstopniceRepository;

import java.util.List;

@Service
public class VstopniceService {
    @Autowired
    private VstopniceRepository vstopniceRepository;

    public List<Vstopnice> pronadjiKorisnikeSaCenomVstopnice(int cena) {
        return vstopniceRepository.pronadjiKorisnikeSaCenomVstopnice(cena);
    }

    public List<Vstopnice> findByCena(float cena){
        return vstopniceRepository.findAllByCena(cena);
    }

}
