package bdbt.jednostka_akademicka.jezyk;

public class Jezyk {



    private int nrJezyka;

    private String kodJezyka;
    private String nazwa;

    public Jezyk() {
    }

    public Jezyk(String kodJezyka, String nazwa) {
        this.kodJezyka = kodJezyka;
        this.nazwa = nazwa;
    }

    public int getNrJezyka() {
        return nrJezyka;
    }

    public void setNrJezyka(int nrJezyka) {
        this.nrJezyka = nrJezyka;
    }

    public String getKodJezyka() {
        return kodJezyka;
    }

    public void setKodJezyka(String kodJezyka) {
        this.kodJezyka = kodJezyka;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "Jezyk{" +
                "id=" + nrJezyka +
                ", kodJezyka='" + kodJezyka + '\'' +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }
}
