package bdbt.jednostka_akademicka.naukowi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Naukowy {
    private int nrPracownika;
    private String tytulNaukowy;
    private String OKNO;
}
