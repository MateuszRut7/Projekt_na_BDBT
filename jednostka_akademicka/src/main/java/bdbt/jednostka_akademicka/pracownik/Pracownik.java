package bdbt.jednostka_akademicka.pracownik;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pracownik {
    private int nrPracownika;
    private String imie;
    private String nazwisko;
    private String dataUrodzenia;
    private String plec;
    private String pesel;

    @Pattern(regexp="^\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$")
    private String dataZatrudnienia;

    @Pattern(regexp="^\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$")
    private String dataZwolnienia;

    private String nrTelefonu;
    private String email;
    private int nrUczelni;
    private int nrWydzialu;
    private int nrAdresu;
    private int nrStanowiska;

}
