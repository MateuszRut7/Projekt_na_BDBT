package bdbt.jednostka_akademicka.dziekanat;

public class Dziekanat {
    private int nrBiuraDziekanatu;
    private int pokoj;
    private String nrTelefonu;
    private String sekcja;
    private int nrWydzialu;

    public Dziekanat() {
    }

    public Dziekanat( int pokoj, String nrTelefonu, String sekcja, int nrWydzialu) {
        this.pokoj = pokoj;
        this.nrTelefonu = nrTelefonu;
        this.sekcja = sekcja;
        this.nrWydzialu = nrWydzialu;
    }

    public int getNrBiuraDziekanatu() {
        return nrBiuraDziekanatu;
    }

    public void setNrBiuraDziekanatu(int nrBiuraDziekanatu) {
        this.nrBiuraDziekanatu = nrBiuraDziekanatu;
    }

    public int getPokoj() {
        return pokoj;
    }

    public void setPokoj(int pokoj) {
        this.pokoj = pokoj;
    }

    public String getNrTelefonu() {
        return nrTelefonu;
    }

    public void setNrTelefonu(String nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }

    public String getSekcja() {
        return sekcja;
    }

    public void setSekcja(String sekcja) {
        this.sekcja = sekcja;
    }

    public int getNrWydzialu() {
        return nrWydzialu;
    }

    public void setNrWydzialu(int nrWydzialu) {
        this.nrWydzialu = nrWydzialu;
    }
}
