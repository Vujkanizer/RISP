package si.um.feri.ris.requests;

import java.time.LocalDateTime;

public class AddDogodekRequest {

    private String naziv;
    private LocalDateTime datum;
    private String opis;
    private float cenaVstopnice;
    private int steviloVstopnic;
    private int steviloMiz;
    private boolean odobren;

    private int klubDogodek;
    private int uporabnik;


    public AddDogodekRequest() {
    }

    public AddDogodekRequest(String naziv, LocalDateTime datum, String opis, float cenaVstopnice, int steviloVstopnic, boolean odobren, int klubDogodek, int steviloMiz, int uporabnik) {
        this.naziv = naziv;
        this.datum = datum;
        this.opis = opis;
        this.cenaVstopnice = cenaVstopnice;
        this.steviloVstopnic = steviloVstopnic;
        this.odobren = odobren;
        this.klubDogodek = klubDogodek;
        this.steviloMiz = steviloMiz;
        this.uporabnik = uporabnik;

    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public void setDatum(LocalDateTime datum) {
        this.datum = datum;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public float getCenaVstopnice() {
        return cenaVstopnice;
    }

    public void setCenaVstopnice(float cenaVstopnice) {
        this.cenaVstopnice = cenaVstopnice;
    }

    public int getSteviloVstopnic() {
        return steviloVstopnic;
    }

    public void setSteviloVstopnic(int steviloVstopnic) {
        this.steviloVstopnic = steviloVstopnic;
    }

    public boolean isOdobren() {
        return odobren;
    }

    public void setOdobren(boolean odobren) {
        this.odobren = odobren;
    }

    public int getKlubDogodek() {
        return klubDogodek;
    }

    public void setKlubDogodek(int klubDogodek) {
        this.klubDogodek = klubDogodek;
    }

    public int getSteviloMiz() {
        return steviloMiz;
    }

    public void setSteviloMiz(int steviloMiz) {
        this.steviloMiz = steviloMiz;
    }

    public int getUporabnik() {
        return uporabnik;
    }

    public void setUporabnik(int uporabnik) {
        this.uporabnik = uporabnik;
    }
}
