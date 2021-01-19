package bdbt.jednostka_akademicka.student;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

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

    @Pattern(regexp="^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$")
    private String dataUrodzenia;

    private String email;
    private String nrTelefonu;
    private String stopienStudiow;
    private String kierunekStudiow;
    private int nrUczelni;
    private int nrAdresu;

}
