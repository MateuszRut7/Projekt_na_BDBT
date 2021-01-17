package bdbt.jednostka_akademicka.administracyjny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Administracyjny {
    private int nrPracownika;
    private String msOffice;
    private int nrBiuraDziekanatu;
}
