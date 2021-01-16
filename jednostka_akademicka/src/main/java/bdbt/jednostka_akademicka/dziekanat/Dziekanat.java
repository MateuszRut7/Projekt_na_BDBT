package bdbt.jednostka_akademicka.dziekanat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dziekanat {
    private int nrBiuraDziekanatu;
    private int pokoj;
    private String nrTelefonu;
    private String sekcja;
    private int nrWydzialu;



}
