package bdbt.jednostka_akademicka.wynagrodzenie;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wynagrodzenie {
    private int nrWynagrodzenia;
    private String dataWynagrodzenia;
    private double kwotaPod;
    private double kwotaDod;
    private int nrPracownika;
}
