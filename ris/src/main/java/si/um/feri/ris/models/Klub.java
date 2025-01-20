package si.um.feri.ris.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Collection;

@Entity
public class Klub {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idKlub;

    private String naziv;
    private String adresa;
    private int telefon;
    private int PIB;
    private boolean status;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "tip_kluba_idtip_kluba")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties("klubi")
   @JsonIgnore
    Tip_kluba tip_kluba;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "uporabnik_iduporabnik")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Uporabnik uporabnik;

    @OneToMany(mappedBy = "idDogodek", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Collection<Dogodek> dogodki;

    @OneToMany(mappedBy = "idRecenzija", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Collection<Recenzija> recenzije;

    public Long getIdKlub() {
        return idKlub;
    }

    public void setIdKlub(Long idklub) {
        this.idKlub = idklub;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public int getPIB() {
        return PIB;
    }

    public void setPIB(int PIB) {
        this.PIB = PIB;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Tip_kluba getTip_kluba() {
        return tip_kluba;
    }

    public void setTip_kluba(Tip_kluba tip_kluba) {
        this.tip_kluba = tip_kluba;
    }

    public Uporabnik getUporabnik() {
        return uporabnik;
    }

    public void setUporabnik(Uporabnik uporabnik) {
        this.uporabnik = uporabnik;
    }
}
