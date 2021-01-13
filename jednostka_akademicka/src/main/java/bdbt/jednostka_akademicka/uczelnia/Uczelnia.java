package bdbt.jednostka_akademicka.uczelnia;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Uczelnia {

    private int nrUczelni;

    private String nazwa;
    private String typUczelni;
    private String rodzaj;
    private int nrAdresu;


}