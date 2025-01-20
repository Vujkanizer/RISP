package si.um.feri.ris.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.web.jsf.FacesContextUtils;

@Entity
public class Miza {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMiza;

    private boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tip_mize_idtip_mize")
    @OnDelete(action = OnDeleteAction.CASCADE)
    Tip_mize tipMize;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rezervacija_idrezervacija")
    @OnDelete(action = OnDeleteAction.CASCADE)
    Rezervacija rezervacija;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dogodek_iddogodek")
    @OnDelete(action = OnDeleteAction.CASCADE)
    Dogodek dogodek;

    public Long getIdMiza() {
        return idMiza;
    }

    public void setIdMiza(Long idMiza) {
        this.idMiza = idMiza;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Tip_mize getTipMize() {
        return tipMize;
    }

    public void setTipMize(Tip_mize tipMize) {
        this.tipMize = tipMize;
    }

    public Rezervacija getRezervacija() {
        return rezervacija;
    }

    public void setRezervacija(Rezervacija rezervacija) {
        this.rezervacija = rezervacija;
    }

    public Dogodek getDogodek() {
        return dogodek;
    }

    public void setDogodek(Dogodek dogodek) {
        this.dogodek = dogodek;
    }
}
