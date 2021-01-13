package bdbt.jednostka_akademicka.pracownik;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String dataZatrudnienia;
    private String dataZwolnienia;
    private String nrTelefonu;
    private String email;
    private int nrUczelni;
    private int nrWydzialu;
    private int nrAdresu;
    private int nrStanowiska;

}
