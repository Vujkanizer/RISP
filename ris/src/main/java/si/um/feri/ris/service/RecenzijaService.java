package si.um.feri.ris.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import si.um.feri.ris.models.Klub;
import si.um.feri.ris.models.Recenzija;
import si.um.feri.ris.models.Uporabnik;
import si.um.feri.ris.repository.RecenzijaRepository;

import java.util.List;

@Service
public class RecenzijaService {
    @Autowired
    private RecenzijaRepository recenzijaRepository;

    public RecenzijaRepository getRecenzijaRepository() {
        return recenzijaRepository;
    }

    public List<Recenzija> findNaziveKlubovaZaRecenzijeSaOcenomManjomOd(int ocena) {
        return recenzijaRepository.findNaziveKlubovaZaRecenzijeSaOcenomManjomOd(ocena);
    }

        public List<Recenzija> findImeIPrezime(int ocena){
            return recenzijaRepository.findImeIPrezime(ocena);
        }

        public List<Recenzija> findByOcena(int ocena){
            return recenzijaRepository.findAllByOcena(ocena);
        }
    }