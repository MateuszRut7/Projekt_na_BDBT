package bdbt.jednostka_akademicka.uczelnia;



public class Uczelnia {

    private int nrUczelni;

    private String nazwa;
    private String typUczelni;
    private String rodzaj;
    private int nrAdresu;

    public Uczelnia() {
    }

    public Uczelnia(int nrUczelni, String nazwa, String typUczelni, String rodzaj, int nrAdresu) {
        super();
        this.nrUczelni = nrUczelni;
        this.nazwa = nazwa;
        this.typUczelni = typUczelni;
        this.rodzaj = rodzaj;
        this.nrAdresu = nrAdresu;
    }

    public int getNrUczelni() {
        return nrUczelni;
    }

    public void setNrUczelni(int nrUczelni) {
        this.nrUczelni = nrUczelni;
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
        this.rodzaj = rodzaj;
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
                "id=" + nrUczelni +
                ", nazwa='" + nazwa + '\'' +
                ", typUczelni='" + typUczelni + '\'' +
                ", rodzaj='" + rodzaj + '\'' +
                ", nrAdresu=" + nrAdresu +
                '}';
    }
}