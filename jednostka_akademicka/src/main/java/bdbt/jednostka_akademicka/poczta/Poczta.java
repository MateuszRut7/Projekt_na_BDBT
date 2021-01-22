package bdbt.jednostka_akademicka.poczta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Poczta {
    private int nrPoczty;
    private String kodPoczty;

    @Column(name="POCZTA")
    private String miasto;
}
