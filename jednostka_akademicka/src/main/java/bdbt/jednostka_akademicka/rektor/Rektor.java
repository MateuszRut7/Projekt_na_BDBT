package bdbt.jednostka_akademicka.rektor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rektor {
    private int nrRektora;
    private String Imie;
    private String Nazwisko;
    private String DataUrodzenia;
    private int nrUczelni;
    private int nrAdresu;


}
