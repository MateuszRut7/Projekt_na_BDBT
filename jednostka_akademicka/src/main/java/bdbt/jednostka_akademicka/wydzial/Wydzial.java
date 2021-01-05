package bdbt.jednostka_akademicka.wydzial;

public class Wydzial {
    private int nrWydzialu;
    private String nazwa;
    private int nrUczelni;
    private int nrAdresu;

    public Wydzial() {
    }

    public Wydzial(String nazwa, int nrUczelni, int nrAdresu) {
        this.nazwa = nazwa;
        this.nrUczelni = nrUczelni;
        this.nrAdresu = nrAdresu;
    }

    public int getNrWydzialu() {
        return nrWydzialu;
    }

    public void setNrWydzialu(int nrWydzialu) {
        this.nrWydzialu = nrWydzialu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getNrUczelni() {
        return nrUczelni;
    }

    public void setNrUczelni(int nrUczelni) {
        this.nrUczelni = nrUczelni;
    }

    public int getNrAdresu() {
        return nrAdresu;
    }

    public void setNrAdresu(int nrAdresu) {
        this.nrAdresu = nrAdresu;
    }

    @Override
    public String toString() {
        return "Wydzial{" +
                "nrWydzialu=" + nrWydzialu +
                ", nazwa='" + nazwa + '\'' +
                ", nrUczelni=" + nrUczelni +
                ", nrAdresu=" + nrAdresu +
                '}';
    }
}
