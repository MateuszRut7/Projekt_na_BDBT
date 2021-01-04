package bdbt.jednostka_akademicka.jezyki;

public class Jezyk {

    private int id;
    private String kodJezyka;
    private String nazwa;

    public Jezyk() {
    }

    public Jezyk(int id, String kodJezyka, String nazwa) {
        this.id = id;
        this.kodJezyka = kodJezyka;
        this.nazwa = nazwa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", kodJezyka='" + kodJezyka + '\'' +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }
}
