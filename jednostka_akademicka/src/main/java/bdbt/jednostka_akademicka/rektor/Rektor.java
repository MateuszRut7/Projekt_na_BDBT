package bdbt.jednostka_akademicka.rektor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rektor {
    private int nrRektora;
    private String imie;
    private String nazwisko;

    @Pattern(regexp="^\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$")
    private String dataUrodzenia;

    private int nrUczelni;
    private int nrAdresu;


}
