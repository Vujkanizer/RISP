package si.um.feri.ris.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
public class Vstopnice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idVstopnice;

    private Date datum;
    private int cena;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dogodek_iddogodek")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties("vstopnice")
    Dogodek dogodek;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uporabnik_iduporabnik")
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnoreProperties("vstopnice")
    Uporabnik uporabnik;

    public Long getIdVstopnice() {
        return idVstopnice;
    }

    public void setIdVstopnice(Long idVstopnice) {
        this.idVstopnice = idVstopnice;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public Dogodek getDogodek() {
        return dogodek;
    }

    public void setDogodek(Dogodek dogodek) {
        this.dogodek = dogodek;
    }

    public Uporabnik getUporabnik() {
        return uporabnik;
    }

    public void setUporabnik(Uporabnik uporabnik) {
        this.uporabnik = uporabnik;
    }
}
