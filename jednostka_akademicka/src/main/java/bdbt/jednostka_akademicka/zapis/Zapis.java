package bdbt.jednostka_akademicka.zapis;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Zapis {
    private int nrStudenta;
    private int nrPrzedmiotu;
    private double ocenaKoncowa;
}
