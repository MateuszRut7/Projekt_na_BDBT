package bdbt.jednostka_akademicka.wynagrodzenie;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wynagrodzenie {
    private int nrWynagrodzenia;

    @Pattern(regexp="^\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$")
    private String dataWynagrodzenia;

    private double kwotaPod;
    private double kwotaDod;
    private int nrPracownika;
}
