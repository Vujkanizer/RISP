package si.um.feri.ris.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Collection;

@Entity
public class Recenzija {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRecenzija;

    private int ocena;
    private String tekst;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "klub_idklub")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Klub klub;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uporabnik_iduporabnik")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Uporabnik uporabnik;


    public Uporabnik getUporabnik() {
        return uporabnik;
    }

    public void setUporabnik(Uporabnik uporabnik) {
        this.uporabnik = uporabnik;
    }

    public Long getIdRecenzija() {
        return idRecenzija;
    }

    public void setIdRecenzija(Long idRecenzija) {
        this.idRecenzija = idRecenzija;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public Klub getKlub() {
        return klub;
    }

    public void setKlub(Klub klub) {
        this.klub = klub;
    }
}
