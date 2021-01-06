package bdbt.jednostka_akademicka.student;

public class Student {
    private int nrStudenta;
    private String imie;
    private String nazwisko;
    private String pesel;
    private String nrIndeksu;
    private String plec;
    private String dataUrodzenia;
    private String email;
    private String nrTelefonu;
    private String stopienStudiow;
    private String kierunekStudiow;
    private int nrUczelni;
    private int nrAdresu;

    public Student() {
    }

    public Student(String imie, String nazwisko, String pesel, String nrIndeksu, String plec, String dataUrodzenia, String email, String nrTelefonu, String stopienStudiow, String kierunekStudiow, int nrUczelni, int nrAdresu) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.nrIndeksu = nrIndeksu;
        this.plec = plec;
        this.dataUrodzenia = dataUrodzenia;
        this.email = email;
        this.nrTelefonu = nrTelefonu;
        this.stopienStudiow = stopienStudiow;
        this.kierunekStudiow = kierunekStudiow;
        this.nrUczelni = nrUczelni;
        this.nrAdresu = nrAdresu;
    }

    public int getNrStudenta() {
        return nrStudenta;
    }

    public void setNrStudenta(int nrStudenta) {
        this.nrStudenta = nrStudenta;
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

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getNrIndeksu() {
        return nrIndeksu;
    }

    public void setNrIndeksu(String nrIndeksu) {
        this.nrIndeksu = nrIndeksu;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(String dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNrTelefonu() {
        return nrTelefonu;
    }

    public void setNrTelefonu(String nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }

    public String getStopienStudiow() {
        return stopienStudiow;
    }

    public void setStopienStudiow(String stopienStudiow) {
        this.stopienStudiow = stopienStudiow;
    }

    public String getKierunekStudiow() {
        return kierunekStudiow;
    }

    public void setKierunekStudiow(String kierunekStudiow) {
        this.kierunekStudiow = kierunekStudiow;
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
}
