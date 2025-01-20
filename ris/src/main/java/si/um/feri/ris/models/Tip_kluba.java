package si.um.feri.ris.models;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Tip_kluba {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTipKluba;

    private String naziv;
    private String opis;

    @OneToMany(mappedBy = "idKlub", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Collection<Klub> klubi;

    public Long getIdTipKluba() {
        return idTipKluba;
    }

    public void setIdTipKluba(Long idTipKluba) {
        this.idTipKluba = idTipKluba;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Collection<Klub> getKlubi() {
        return klubi;
    }

    public void setKlubi(Collection<Klub> klubi) {
        this.klubi = klubi;
    }
}
