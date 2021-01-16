package bdbt.jednostka_akademicka.instytut;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instytut {
    private int nrInstytutu;
    private String Nazwa;
    private int nrWydzialu;
}
