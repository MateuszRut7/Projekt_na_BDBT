package bdbt.jednostka_akademicka.uczelnia;

import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class Uczelnia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nazwa;
    private String typUczelni;
    private String rodzaj;
    private int nrAdresu;

    public Uczelnia() {
    }

    public Uczelnia(int id, String nazwa, String typUczelni, String rodzaj, int nrAdresu) {
        super();
        this.id = id;
        this.nazwa = nazwa;
        this.typUczelni = typUczelni;
        this.rodzaj = rodzaj;
        this.nrAdresu = nrAdresu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getTypUczelni() {
        return typUczelni;
    }

    public void setTypUczelni(String typUczelni) {
        this.typUczelni = typUczelni;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        rodzaj = rodzaj;
    }

    public int getNrAdresu() {
        return nrAdresu;
    }

    public void setNrAdresu(int nrAdresu) {
        this.nrAdresu = nrAdresu;
    }

    @Override
    public String toString() {
        return "Uczelnie{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", typUczelni='" + typUczelni + '\'' +
                ", rodzaj='" + rodzaj + '\'' +
                ", nrAdresu=" + nrAdresu +
                '}';
    }
}
