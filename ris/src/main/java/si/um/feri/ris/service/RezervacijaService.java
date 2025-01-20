package si.um.feri.ris.service;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;
import si.um.feri.ris.models.Miza;
import si.um.feri.ris.models.Rezervacija;
import si.um.feri.ris.models.Uporabnik;
import si.um.feri.ris.repository.MizaRepository;
import si.um.feri.ris.repository.RezervacijaRepository;
import si.um.feri.ris.requests.AddRezervacijaRequest;
import si.um.feri.ris.repository.UporabnikRepository;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
@Service
public class RezervacijaService {
    private final UporabnikRepository userRrepository;
    private RezervacijaRepository rezervacijaRepository;

    private final MizaRepository mizaRepository;

    private JavaMailSender javaMailSender;

    public RezervacijaService(
            UporabnikRepository userRrepository,
            RezervacijaRepository rezervacijaRepository,
            MizaRepository mizaRepository, JavaMailSender javaMailSender) {
        this.userRrepository = userRrepository;
        this.rezervacijaRepository = rezervacijaRepository;
        this.mizaRepository = mizaRepository;
        this.javaMailSender = javaMailSender;
    }

    public List<Rezervacija> getAll() {
        return (List<Rezervacija>) rezervacijaRepository.findAll();
    }

    public Optional<Rezervacija> getById(Long id) {
        return rezervacijaRepository.findById(id);
    }


    public Rezervacija createRezervacija() throws MessagingException {
        Rezervacija r = new Rezervacija();
        r.setDatum(new Date());
        r.setSteviloOseb(5);
        r.setPoruka("TEST");
        Optional<Uporabnik> u = userRrepository.findById(3);
        if (u.isPresent()) {
            Uporabnik user = u.get();
            r.setUporabnik_rezervacija(user);
        }
        Optional<Miza> m = mizaRepository.findById(Long.valueOf(1));
        if (m.isPresent()) {
            Miza miza = m.get();
            r.setMize(miza);
        }
        Rezervacija rezervacija = rezervacijaRepository.save(r);

        this.posaljiEmail(rezervacija);
        return rezervacija;
    }

    public void updateRezervacija(Long id, Rezervacija novaRezervacija) {
        if (rezervacijaRepository.existsById(id)) {
            novaRezervacija.setIdRezervacija(id);
            rezervacijaRepository.save(novaRezervacija);
        }
    }

    public void deleteRezervacija(Long id) {
        rezervacijaRepository.deleteById(id);
    }

    public List<Rezervacija> dohvatiRezervacije(int stevOseb) {
        LocalDateTime pocetak = LocalDateTime.of(2024, 1, 1, 0, 0);
        Timestamp pocetakTimestamp = Timestamp.valueOf(pocetak);
        return rezervacijaRepository.findRezervacijaByDatumAndSteviloOseb(stevOseb, pocetakTimestamp);
    }

    public Rezervacija save(AddRezervacijaRequest rezervacija) {
        Rezervacija r = new Rezervacija();
        r.setDatum(rezervacija.getDatum());
        Optional<Uporabnik> u = userRrepository.findById((int) rezervacija.getUporabnik());
        if (u.isPresent()) {
            r.setUporabnik_rezervacija(u.get());
        }
        Optional<Miza> m = mizaRepository.findById((long) rezervacija.getMiza());
        if (m.isPresent()) {
            r.setMize(m.get());
        }
        r.setSteviloOseb(rezervacija.getSteviloOseb());
        r.setPoruka(rezervacija.getPoruka());
        return rezervacijaRepository.saveAndFlush(r);
    }

    private void posaljiEmail(Rezervacija rezervacija) throws MessagingException {
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        try {
            helper.setTo(rezervacija.getUporabnik_rezervacija().getEmail());
            helper.setSubject("Potvrda rezervacije");
            helper.setText("Spoštovani " + rezervacija.getUporabnik_rezervacija().getIme()
                    +",\n\nVaša rezervacija je potrjena.\n\nHvala vam, ker ste nas izbrali.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(msg);
    }
    }



