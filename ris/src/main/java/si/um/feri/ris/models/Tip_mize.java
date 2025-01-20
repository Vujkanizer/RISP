package si.um.feri.ris.models;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Tip_mize {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int steiloOseb;
    private String naziv;
    private String opis;

    @OneToMany(mappedBy = "idMiza", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Collection<Miza> mize;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSteiloOseb() {
        return steiloOseb;
    }

    public void setSteiloOseb(int steiloOseb) {
        this.steiloOseb = steiloOseb;
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

    public Collection<Miza> getMize() {
        return mize;
    }

    public void setMize(Collection<Miza> mize) {
        this.mize = mize;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
