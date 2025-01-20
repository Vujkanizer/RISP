package si.um.feri.ris.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import si.um.feri.ris.models.Uporabnik;
import si.um.feri.ris.repository.UporabnikRepository;
import si.um.feri.ris.requests.AddDogodekRequest;
import si.um.feri.ris.models.Dogodek;
import si.um.feri.ris.models.Klub;
import si.um.feri.ris.repository.DogodekRepository;
import si.um.feri.ris.repository.KlubRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DogodekService {


    private final DogodekRepository dogodekRepository;
    private final KlubRepository klubRepository;
    private final UporabnikRepository uporabnikRepository;


    public DogodekService(DogodekRepository dogodekRepository, KlubRepository klubRepository, UporabnikRepository uporabnikRepository) {
        this.dogodekRepository = dogodekRepository;
        this.klubRepository = klubRepository;
        this.uporabnikRepository = uporabnikRepository;
    }

    public List<Dogodek> findBydog(boolean odobren, Float cenaVstopnice) {
        return dogodekRepository.findBydog(odobren, cenaVstopnice);
    }

    public List<Dogodek> findByCenaVstopnice(Float cenaVstopnice){
        return dogodekRepository.findAllByCenaVstopnice(cenaVstopnice);
    }

    public Dogodek save(AddDogodekRequest dogodek) {
        Dogodek d = new Dogodek();
        d.setDatum(dogodek.getDatum());
        Optional<Klub> k = klubRepository.findById((long) dogodek.getKlubDogodek());
        if (k.isPresent()) {
            d.setKlub_dogodek(k.get());
        }
        Optional<Uporabnik> u = uporabnikRepository.findById((int) dogodek.getUporabnik());
        if (u.isPresent()) {
            d.setUporabnik_dogodek(u.get());
        }


        d.setNaziv(dogodek.getNaziv());
        d.setOdobren(false);
        d.setOpis(dogodek.getOpis());
        d.setCenaVstopnice(dogodek.getCenaVstopnice());
        d.setSteviloVstopnica(dogodek.getSteviloVstopnic());
        d.setSteviloMiz(dogodek.getSteviloMiz());
        return dogodekRepository.saveAndFlush(d);
    }

    public List<Dogodek> findBySteviloMiz(int steviloMiz){
        return dogodekRepository.findAllBySteviloMiz(steviloMiz);
    }

    public List<Dogodek> findAllByOdobren(){
        return dogodekRepository.findAllByOdobren();
    }

    public List<Dogodek> findByidu(int uporabnik_dogodek){
        return dogodekRepository.findByidu(uporabnik_dogodek);
    }


}
