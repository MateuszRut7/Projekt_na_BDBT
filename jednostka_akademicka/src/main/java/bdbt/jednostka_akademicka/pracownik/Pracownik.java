package bdbt.jednostka_akademicka.pracownik;

public class Pracownik {
    private int nrPracownika;
    private String imie;
    private String nazwisko;
    private String dataUrodzenia;
    private String plec;
    private String pesel;
    private String dataZatrudnienia;
    private String dataZwolnienia;
    private String nrTelefonu;
    private String email;
    private int nrUczelni;
    private int nrWydzialu;
    private int nrAdresu;
    private int nrStanowiska;

    public Pracownik() {
    }

    public Pracownik(String imie, String nazwisko, String dataUrodzenia, String plec, String pesel, String dataZatrudnienia, String dataZwolnienia, String nrTelefonu, String email, int nrUczelni, int nrWydzialu, int nrAdresu, int nrStanowiska) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.plec = plec;
        this.pesel = pesel;
        this.dataZatrudnienia = dataZatrudnienia;
        this.dataZwolnienia = dataZwolnienia;
        this.nrTelefonu = nrTelefonu;
        this.email = email;
        this.nrUczelni = nrUczelni;
        this.nrWydzialu = nrWydzialu;
        this.nrAdresu = nrAdresu;
        this.nrStanowiska = nrStanowiska;
    }

    public int getNrPracownika() {
        return nrPracownika;
    }

    public void setNrPracownika(int nrPracownika) {
        this.nrPracownika = nrPracownika;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(String dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getDataZatrudnienia() {
        return dataZatrudnienia;
    }

    public void setDataZatrudnienia(String dataZatrudnienia) {
        this.dataZatrudnienia = dataZatrudnienia;
    }

    public String getDataZwolnienia() {
        return dataZwolnienia;
    }

    public void setDataZwolnienia(String dataZwolnienia) {
        this.dataZwolnienia = dataZwolnienia;
    }

    public String getNrTelefonu() {
        return nrTelefonu;
    }

    public void setNrTelefonu(String nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNrUczelni() {
        return nrUczelni;
    }

    public void setNrUczelni(int nrUczelni) {
        this.nrUczelni = nrUczelni;
    }

    public int getNrWydzialu() {
        return nrWydzialu;
    }

    public void setNrWydzialu(int nrWydzialu) {
        this.nrWydzialu = nrWydzialu;
    }

    public int getNrAdresu() {
        return nrAdresu;
    }

    public void setNrAdresu(int nrAdresu) {
        this.nrAdresu = nrAdresu;
    }

    public int getNrStanowiska() {
        return nrStanowiska;
    }

    public void setNrStanowiska(int nrStanowiska) {
        this.nrStanowiska = nrStanowiska;
    }
}
