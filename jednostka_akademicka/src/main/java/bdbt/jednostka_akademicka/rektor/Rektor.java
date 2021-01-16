package bdbt.jednostka_akademicka.rektor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rektor {
    private int nrRektora;
    private String imie;
    private String nazwisko;
    private String dataUrodzenia;
    private int nrUczelni;
    private int nrAdresu;


}
