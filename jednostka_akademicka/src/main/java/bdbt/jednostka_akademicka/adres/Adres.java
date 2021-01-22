package bdbt.jednostka_akademicka.adres;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adres {
    private int nrAdresu;
    private String miasto;
    private String ulica;
    private String nrLokalu;
    private int nrPoczty;
}
