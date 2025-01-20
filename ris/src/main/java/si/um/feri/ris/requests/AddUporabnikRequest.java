package si.um.feri.ris.requests;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import si.um.feri.ris.models.Vrsta;

public class AddUporabnikRequest {
    private String ime;
    private String priimek;
    private String email;
    private String geslo;
    @Enumerated(EnumType.STRING)
    private Vrsta vrsta;
    private int telefon;
    private int emso;
    private int davcnaStevilka;



    public AddUporabnikRequest() {

    }

    public AddUporabnikRequest(String ime, String priimek, String email, String geslo, Vrsta vrsta, int telefon, int emso, int davcnaStevilka) {
        this.ime = ime;
        this.priimek = priimek;
        this.email = email;
        this.geslo = geslo;
        this.vrsta = vrsta;
        this.telefon = telefon;
        this.emso = emso;
        this.davcnaStevilka = davcnaStevilka;

    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPriimek() {
        return priimek;
    }

    public void setPriimek(String priimek) {
        this.priimek = priimek;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGeslo() {
        return geslo;
    }

    public void setGeslo(String geslo) {
        this.geslo = geslo;
    }

    public Vrsta getVrsta() {
        return vrsta;
    }

    public void setVrsta(Vrsta vrsta) {
        this.vrsta = vrsta;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public int getEmso() {
        return emso;
    }

    public void setEmso(int emso) {
        this.emso = emso;
    }

    public int getDavcnaStevilka() {
        return davcnaStevilka;
    }

    public void setDavcnaStevilka(int davcnaStevilka) {
        this.davcnaStevilka = davcnaStevilka;
    }


}