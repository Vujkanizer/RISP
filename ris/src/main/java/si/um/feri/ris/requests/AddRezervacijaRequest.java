package si.um.feri.ris.requests;

import java.util.Date;

public class AddRezervacijaRequest {

    private Date datum;
    private int steviloOseb;
    private String poruka;

    private int uporabnik;
    private int miza;

    public AddRezervacijaRequest() {
    }

    public AddRezervacijaRequest(Date datum, int steviloOseb, String poruka, int uporabnik, int miza) {
        this.datum = datum;
        this.steviloOseb = steviloOseb;
        this.poruka = poruka;
        this.uporabnik = uporabnik;
        this.miza = miza;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getSteviloOseb() {
        return steviloOseb;
    }

    public void setSteviloOseb(int steviloOseb) {
        this.steviloOseb = steviloOseb;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public int getUporabnik() {
        return uporabnik;
    }

    public void setUporabnik(int uporabnik) {
        this.uporabnik = uporabnik;
    }

    public int getMiza() {
        return miza;
    }

    public void setMiza(int miza) {
        this.miza = miza;
    }
}
