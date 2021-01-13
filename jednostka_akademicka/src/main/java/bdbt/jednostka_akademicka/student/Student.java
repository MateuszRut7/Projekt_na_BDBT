package bdbt.jednostka_akademicka.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

}
