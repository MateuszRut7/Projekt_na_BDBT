package bdbt.jednostka_akademicka.wydzial;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wydzial {
    private int nrWydzialu;
    private String nazwa;
    private int nrUczelni;
    private int nrAdresu;


}
